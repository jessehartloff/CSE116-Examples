package week2.objects

class Item(val description: String, var price: Double) {

  var timesPurchased: Int = 0

  def purchase(): Unit = {
    this.timesPurchased += 1
  }

  def onSale(): Unit = {
    this.price *= 0.8
  }

}
