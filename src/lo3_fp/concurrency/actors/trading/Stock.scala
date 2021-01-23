package lo3_fp.concurrency.actors.trading

import akka.actor.Actor


class Stock(ticker: String, var price: Double) extends Actor {

  override def receive: Receive = {
    case Tick =>
      val percentChange = 0.05
      price *= 1.0 + (Math.random() - 0.5) * 2.0 * percentChange
      println(ticker + ": " + Math.round(price * 100.0) / 100.0)
    case GetPrice =>
      sender() ! Price(this.price)
  }
}
