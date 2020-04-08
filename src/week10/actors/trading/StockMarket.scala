package week10.actors.trading

import akka.actor.{ActorSystem, Props}
import week10.actors.Update

import scala.concurrent.duration._

object StockMarket {

  def main(args: Array[String]): Unit = {

    val system = ActorSystem("StockMarket")

    val googRef = system.actorOf(Props(classOf[Stock], "GOOG", 1213.39))
    val amazonRef = system.actorOf(Props(classOf[Stock], "AMZN", 2034.32))

    val stocks = Map(googRef -> "GOOG", amazonRef -> "AMZN")

    val trader1 = system.actorOf(Props(classOf[Trader], stocks))
    val trader2 = system.actorOf(Props(classOf[Trader], stocks))

    import system.dispatcher

    system.scheduler.schedule(0.milliseconds, 1000.milliseconds, googRef, Tick)
    system.scheduler.schedule(0.milliseconds, 1000.milliseconds, amazonRef, Tick)
    system.scheduler.schedule(500.milliseconds, 1000.milliseconds, trader1, CheckStocks)
    system.scheduler.schedule(500.milliseconds, 1000.milliseconds, trader2, CheckStocks)


  }

}
