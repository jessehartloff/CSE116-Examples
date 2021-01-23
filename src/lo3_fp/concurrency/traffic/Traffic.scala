package lo3_fp.concurrency.traffic

import akka.actor.{ActorSystem, Props}

object Traffic {


  def main(args: Array[String]): Unit = {

    val system = ActorSystem("TrafficSimulator")

    val intersection1 = system.actorOf(Props(classOf[Intersection], 2000))
    val intersection2 = system.actorOf(Props(classOf[Intersection], 2500))
    val intersection3 = system.actorOf(Props(classOf[Intersection], 4000))
    val intersection4 = system.actorOf(Props(classOf[Intersection], 10000))

    val route1 = List(
      Direction(intersection1, 5000, true),
      Direction(intersection2, 3000, false),
      Direction(intersection3, 8000, false),
      Direction(intersection4, 2000, true)
    )

    system.actorOf(Props(classOf[Car], route1))
    system.actorOf(Props(classOf[Car], route1))
    system.actorOf(Props(classOf[Car], route1))

    val route2 = List(
      Direction(intersection3, 10000, false),
      Direction(intersection2, 6000, false),
      Direction(intersection4, 1800, true),
      Direction(intersection1, 4000, true)
    )

    system.actorOf(Props(classOf[Car], route2))

  }

}
