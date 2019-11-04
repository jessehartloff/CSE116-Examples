package week11.equipment

abstract class Equipment {

  var numberOwned: Int = 0
  var name: String = ""

  def goldPerSecond(): Double = {
    0.0
  }

  def goldPerClick(): Double = {
    0.0
  }

  def costOfNextPurchase(): Double = {
    0.0
  }

  def buy(): Unit = {
    println("buy called from " + this.name)
  }

}
