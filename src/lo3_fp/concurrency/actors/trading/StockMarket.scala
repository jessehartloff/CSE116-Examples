package lo3_fp.concurrency.actors.trading

import akka.actor.{ActorSystem, Props}

import scala.concurrent.duration
import scala.concurrent.duration.FiniteDuration

object StockMarket {

  def main(args: Array[String]): Unit = {

    val system = ActorSystem("StockMarket")

    val googRef = system.actorOf(Props(classOf[Stock], "GOOG", 1213.39))
    val amazonRef = system.actorOf(Props(classOf[Stock], "AMZN", 2034.32))

    val stocks = Map(googRef -> "GOOG", amazonRef -> "AMZN")

    val trader1 = system.actorOf(Props(classOf[Trader], stocks))
//    val trader2 = system.actorOf(Props(classOf[Trader], stocks))

    import system.dispatcher

    system.scheduler.scheduleAtFixedRate(FiniteDuration(0, duration.MILLISECONDS), FiniteDuration(1000, duration.MILLISECONDS), googRef, Tick)
    system.scheduler.scheduleAtFixedRate(FiniteDuration(0, duration.MILLISECONDS), FiniteDuration(1000, duration.MILLISECONDS), amazonRef, Tick)
    system.scheduler.scheduleAtFixedRate(FiniteDuration(580, duration.MILLISECONDS), FiniteDuration(1000, duration.MILLISECONDS), trader1, CheckStocks)
//    system.scheduler.scheduleAtFixedRate(FiniteDuration(500, duration.MILLISECONDS), FiniteDuration(1000, duration.MILLISECONDS), trader2, CheckStocks)


  }

}
