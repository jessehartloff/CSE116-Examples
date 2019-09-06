package week2.objects

object ItemMain {

  def printPrice(item: Item): Unit = {
    println("Current price of "+ item.description +" is: $" + item.price)
  }

  def main(args: Array[String]): Unit = {

    val cereal: Item = new Item("cereal", 3.0)
    val milk: Item = new Item("milk", 2.0)

    // Change state using behavior
    cereal.purchase()
    cereal.onSale()
    cereal.purchase()

    println(cereal.description + " has been purchased " + cereal.timesPurchased + " times")
    printPrice(cereal)

    // Change state directly
    milk.price = 1.5

    printPrice(milk)
  }

}
