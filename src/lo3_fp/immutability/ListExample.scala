package lo3_fp.immutability

object ListExample {

  def firstNPrimes(n: Int): List[Int] = {
    if (n < 1) {
      List()
    } else if (n == 1) {
      List(2)
    } else {
      val nMinusOnePrimes: List[Int] = firstNPrimes(n - 1)
      val next: List[Int] = nMinusOnePrimes.tail
      val maxPrime: Int = nMinusOnePrimes.max
      findPrime(maxPrime + 1, nMinusOnePrimes) :: nMinusOnePrimes
    }
  }

  def findPrime(i: Int, knownPrimes: List[Int]): Int = {
    if (!knownPrimes.foldLeft(false)(_ || i % _ == 0)) {
      i
    } else {
      findPrime(i + 1, knownPrimes)
    }
  }


  def main(args: Array[String]): Unit = {
    firstNPrimes(100).foreach(println)
  }

}
