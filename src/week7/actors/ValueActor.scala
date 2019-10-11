package week7.actors

import akka.actor.Actor

case class Increase(i: Int)
case object GetValue
case class Value(i: Int)

class ValueActor(var x: Int) extends Actor {

  override def receive: Receive = {
    case inc: Increase => x += inc.i
    case GetValue => sender() ! Value(x)
  }

}

