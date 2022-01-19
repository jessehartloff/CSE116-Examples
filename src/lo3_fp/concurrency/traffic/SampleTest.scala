package lo3_fp.concurrency.traffic

import akka.actor.{ActorSystem, Props}
import akka.testkit.{ImplicitSender, TestKit}
import org.scalatest.{BeforeAndAfterAll, Matchers, WordSpecLike}

import scala.concurrent.duration
import scala.concurrent.duration._

class SampleTest() extends TestKit(ActorSystem("TestTrafficActors"))
  with ImplicitSender
  with WordSpecLike
  with Matchers
  with BeforeAndAfterAll {

  override def afterAll(): Unit = {
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


      // t=0 intersection1 green EastWest; intersection2 green EastWest
      // check at 0(ish)
      // t=200 intersection1 red EastWest; intersection2 green EastWest
      // t=300 car arrives at intersection1 from EastWest
      // check at 350(ish)
      // t=400 intersection1 green EastWest; intersection2 green EastWest
      // t=400 car gets green light and drives to intersection2
      // check at 450(ish)
      // t=500 intersection1 green EastWest; intersection2 red EastWest
      // t=600 intersection1 red EastWest; intersection2 red EastWest
      // t=800 intersection1 green EastWest; intersection2 red EastWest
      // t=900 car arrives at intersection2 from NorthSouth
      // t=900 car gets green light and arrives at destination
      // t=1000 intersection1 red EastWest; intersection2 green EastWest

      // t=2000 intersection1 green EastWest; intersection2 green EastWest


      val car = system.actorOf(Props(classOf[Car], route1))

      car ! GetNextDirection
      var direction: Direction = expectMsgType[Direction](FiniteDuration(1000, duration.MILLISECONDS))
      assert(direction == Direction(intersection1, 300, true))

      expectNoMessage(FiniteDuration(350, duration.MILLISECONDS))

      car ! GetNextDirection
      direction = expectMsgType[Direction](FiniteDuration(1000, duration.MILLISECONDS))
      assert(direction == Direction(intersection1, 300, true))

      expectNoMessage(FiniteDuration(100, duration.MILLISECONDS))

      car ! GetNextDirection
      direction = expectMsgType[Direction](FiniteDuration(1000, duration.MILLISECONDS))
      assert(direction == Direction(intersection2, 500, false))


      expectNoMessage(FiniteDuration(500, duration.MILLISECONDS))

    }
  }

}
