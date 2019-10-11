package week7.actors

import akka.actor.{ActorSystem, Props}
import akka.testkit.{ImplicitSender, TestKit}
import org.scalatest.{BeforeAndAfterAll, Matchers, WordSpecLike}

import scala.concurrent.duration._

class TestActors() extends TestKit(ActorSystem("TestValueActor"))
  with ImplicitSender
  with WordSpecLike
  with Matchers
  with BeforeAndAfterAll {

  override def afterAll: Unit = {
    TestKit.shutdownActorSystem(system)
  }

  "A value actor" must {
    "track a value" in {
      val valueActor = system.actorOf(Props(classOf[ValueActor], 10))

      valueActor ! Increase(5)
      valueActor ! Increase(5)

      expectNoMessage(100.millis)

      valueActor ! GetValue
      val value: Value = expectMsgType[Value](1000.millis)

      assert(value == Value(20))
    }
  }

}
