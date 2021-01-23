package lo3_fp.concurrency.actors.trading

import akka.actor.{Actor, ActorRef}

class Trader(stocks: Map[ActorRef, String]) extends Actor {

  var currency: Double = 100000.0
  var stocksOwned: Map[String, Int] = (for(ticker <- stocks.values) yield {ticker -> 0}).toMap

  override def receive: Receive = {
    case CheckStocks =>
      println("\nchecking stocks")
      println("Cash on hand: " + currency)
      println("Currently own: " + stocksOwned)
      stocks.keys.foreach(_ ! GetPrice)
    case p: Price =>
      val ticker = stocks.getOrElse(sender(), "")
      if(ticker != ""){
        if(Math.random() > 0.9){
          val quantity = (Math.random()*10).toInt.max(1)
          if(p.price * quantity < currency) {
            this.currency -= p.price * quantity
            stocksOwned += ticker -> (stocksOwned(ticker) + quantity)
          }
        }
      }
  }
}