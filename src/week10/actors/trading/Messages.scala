package week10.actors.trading


case object Tick
case object GetPrice
case class Price(price: Double)
case object CheckStocks
