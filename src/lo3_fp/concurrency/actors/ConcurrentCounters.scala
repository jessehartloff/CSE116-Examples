package lo3_fp.concurrency.actors

import akka.actor._

import scala.concurrent.duration
import scala.concurrent.duration.FiniteDuration

case object Start
case object Update
case object IsDone
case object Done
case object NotDone


class Counter(name: String) extends Actor {

  var n = 0

  def countDown(): Unit = {
    if (n >= 0) {
      println(this.name + " - " + n)
      n -= 1
      countDown()
    } else {
      println(this.name + " finished")
    }
  }

  def receive: Receive = {
    case Start =>
      this.n = 20
      countDown()
    case IsDone =>
      if (n <= 0) {
        sender() ! Done
      } else {
        sender() ! NotDone
      }
  }

}


class Supervisor(counters: List[ActorRef]) extends Actor {

  var total: Int = counters.size
  var completed: List[ActorRef] = List()

  def receive: Receive = {
    case Update =>
      counters.foreach((actor: ActorRef) => actor ! IsDone)
    case Done =>
      if(!completed.contains(sender())){
        completed ::= sender()
        if (completed.size == this.total) {
          println("All counters complete")
        }
      }
    case NotDone =>
      println("A counter is not done yet")

  }

}


object CounterTest {
  def main(args: Array[String]): Unit = {

    val system = ActorSystem("CountingSystem")

    import system.dispatcher

    val one = system.actorOf(Props(classOf[Counter], "1"))
    val two = system.actorOf(Props(classOf[Counter], "2"))
    val three = system.actorOf(Props(classOf[Counter], "3"))

    val supervisor = system.actorOf(Props(classOf[Supervisor], List(one, two, three)))

    one ! Start
    two ! Start
    three ! Start

    system.scheduler.scheduleAtFixedRate(FiniteDuration(0, duration.MILLISECONDS), FiniteDuration(500, duration.MILLISECONDS), supervisor, Update)
  }
}