package week3.memory

object Basics {

  def computeFactorial(n: Int): Int = {
    var result: Int = 1
    for (i <- 1 to n) {
      result *= i
    }
    result
  }

  def main(args: Array[String]): Unit = {
    val i: Int = 5
    val n = computeFactorial(i)
    println(n)
  }

}
