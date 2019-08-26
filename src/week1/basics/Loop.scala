package week1.basics

object Loop {

  def printOneTo(n: Int): Unit = {
    for (i <- 1 to n) {
      println("i == " + i)
    }
  }

  def printOneToAlternate(n: Int): Unit = {
    val numbers: Range = 1 to n
    for (i <- numbers) {
      println("i == " + i)
    }
  }

  def main(args: Array[String]): Unit = {
    printOneToAlternate(10)
  }

}
