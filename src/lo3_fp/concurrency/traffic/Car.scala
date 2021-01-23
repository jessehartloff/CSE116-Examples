package lo3_fp.concurrency.traffic

import akka.actor.Actor

import scala.concurrent.duration
import scala.concurrent.duration._

class Car(var directions: List[Direction]) extends Actor{

  import context.dispatcher

  self ! directions.head

  override def receive: Receive = {
    case approaching: Approaching =>
      if(approaching.eastWest) {
        println("approaching intersection from East/West: " + approaching.intersection)
        approaching.intersection ! ApproachingEastWest
      }else{
        println("approaching intersection from North/South: " + approaching.intersection)
        approaching.intersection ! ApproachingNorthSouth
      }
    case direction: Direction =>
      context.system.scheduler.scheduleOnce(
        FiniteDuration(direction.timeReachIntersection, duration.MILLISECONDS),
        self,
        Approaching(direction.intersection, direction.eastWest)
      )
    case GreenLight =>
      directions = directions.tail
      if(directions.nonEmpty) {
        println("driving to intersection: " + directions.head.intersection)
        self ! directions.head
      }else{
        // arrived at destination
      }

    // Used for testing
    case GetNextDirection =>
      if(directions.nonEmpty) {
        sender() ! directions.head
      }else{
        sender() ! ArrivedAtDestination
      }
  }
}
