package week10.traffic

import akka.actor.{ActorSystem, Props}
import akka.testkit.{ImplicitSender, TestKit}
import org.scalatest.{BeforeAndAfterAll, Matchers, WordSpecLike}

import scala.concurrent.duration._

class SampleTest() extends TestKit(ActorSystem("TestTrafficActors"))
  with ImplicitSender
  with WordSpecLike
  with Matchers
  with BeforeAndAfterAll {

  override def afterAll: Unit = {
    TestKit.shutdownActorSystem(system)
  }

  "A car actor" must {
    "obey traffic signals" in {

      val intersection1 = system.actorOf(Props(classOf[Intersection], 200))
      val intersection2 = system.actorOf(Props(classOf[Intersection], 500))

      val route1 = List(
        Direction(intersection1, 300, true),
        Direction(intersection2, 500, false)
      )

      val car = system.actorOf(Props(classOf[Car], route1))

      car ! GetNextDirection
      var direction: Direction = expectMsgType[Direction](1000.millis)
      assert(direction == Direction(intersection1, 300, true))

      expectNoMessage(350.millis)

      car ! GetNextDirection
      direction = expectMsgType[Direction](1000.millis)
      assert(direction == Direction(intersection1, 300, true))

      expectNoMessage(100.millis)

      car ! GetNextDirection
      direction = expectMsgType[Direction](1000.millis)
      assert(direction == Direction(intersection2, 500, false))

    }
  }

}
