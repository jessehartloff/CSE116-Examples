package lo3_fp.concurrency.actors.trading


case object Tick
case object GetPrice
case class Price(price: Double)
case object CheckStocks
