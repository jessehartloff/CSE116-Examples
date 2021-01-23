package lo3_fp.concurrency.traffic

import akka.actor.{Actor, ActorRef}

import scala.concurrent.duration
import scala.concurrent.duration._

class Intersection(timeInterval: Int) extends Actor {

  var redEastWest: Boolean = true
  var waitingEastWest: List[ActorRef] = List()
  var waitingNorthSouth: List[ActorRef] = List()

  import context.dispatcher

  self ! ChangeLight

  override def receive: Receive = {
    case ApproachingEastWest =>
      if (redEastWest) {
        waitingEastWest ::= sender()
      } else {
        sender() ! GreenLight
      }
    case ApproachingNorthSouth =>
      if (redEastWest) {
        sender() ! GreenLight
      }else {
        waitingNorthSouth ::= sender()
      }
    case ChangeLight =>
      if (redEastWest) {
        println("Green East/West at intersection: " + self)
        waitingEastWest.foreach(_ ! GreenLight)
        waitingEastWest = List()
      } else {
        println("Green North/South at intersection: " + self)
        waitingNorthSouth.foreach(_ ! GreenLight)
        waitingNorthSouth = List()
      }
      redEastWest = !redEastWest
      context.system.scheduler.scheduleOnce(
        FiniteDuration(timeInterval, duration.MILLISECONDS),
        self,
      ChangeLight
    )
  }

}
