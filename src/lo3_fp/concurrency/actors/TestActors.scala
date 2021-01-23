package lo3_fp.concurrency.actors

import akka.actor.{ActorSystem, Props}
import akka.testkit.{ImplicitSender, TestKit}
import org.scalatest.{BeforeAndAfterAll, Matchers, WordSpecLike}

import scala.concurrent.duration
import scala.concurrent.duration.FiniteDuration

class TestActors() extends TestKit(ActorSystem("TestValueActor"))
  with ImplicitSender
  with WordSpecLike
  with Matchers
  with BeforeAndAfterAll {

  override def afterAll(): Unit = {
    TestKit.shutdownActorSystem(system)
  }

  "A value actor" must {
    "track a value" in {
      val valueActor = system.actorOf(Props(classOf[ValueActor], 10))

      valueActor ! Increase(5)
      valueActor ! Increase(5)

      expectNoMessage(FiniteDuration(100, duration.MILLISECONDS))

      valueActor ! GetValue
      val value: Value = expectMsgType[Value](FiniteDuration(1000, duration.MILLISECONDS))

      assert(value == Value(20))
    }
  }

}
