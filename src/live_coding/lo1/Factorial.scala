package live_coding.lo1

object Factorial {

  // Write a method named factorial that takes an Int as a parameter and returns an Int. The
  // method will return the factorial of the input. Ex. factorial(3) should return 6
  def factorial(n: Int): Int = {
    var answer: Int = 1
    for(i <- 1 to n){
      answer *= i
    }
    answer
  }

  def main(args: Array[String]): Unit = {
    val x: Int = factorial(5)
    println(x) // expect 120
  }

}
