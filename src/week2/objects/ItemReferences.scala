package week2.objects

object ItemReferences {

  def increasePrice(item: Item): Unit = {
    item.price += 0.25
  }

  def main(args: Array[String]): Unit = {

    val cereal: Item = new Item("cereal", 3.0)

    // pass-by-reference
    increasePrice(cereal)

    // assignment-by-reference
    val cereal2: Item = cereal

    increasePrice(cereal2)

    // 3.5
    println(cereal.price)
  }

}
