package lo1_program_execution.scala

object ListExample {

  def listExample(): Unit = {
    var primes: List[Int] = List(3, 5, 7)

    println("1: " + primes)

    // prepend 2 to the beginning of the list
    primes = 2 :: primes

    // append 11 to the end of the list
    primes = primes :+ 11

    println("2: " + primes)

    // Don't make this mistake! Must reassign to primes with "primes ="
    primes :+ 13

    // Primes does not contain 13
    println("3: " + primes)

    primes = primes :+ 13

    // Primes does contain 13
    println("4: " + primes)

    // Can also use shorthand syntax
    primes :+= 17
    primes ::= 1
    primes ::= 0

    println("5: " + primes)

    // Oops, 0 and 1 are not prime numbers. Remove them from the list
    // drop removes the first n values of the list
    primes = primes.drop(2)

    println("6: " + primes)

    // Can remove elements from the end of the list with dropRight
    primes = primes.dropRight(1)

    println("7: " + primes)

    // Create a new list to store the square of each prime
    var primesSquared: List[Int] = List()

    for(primeNumber <- primes){
      primesSquared :+= primeNumber * primeNumber
    }

    println("8: " + primesSquared)
    println()

    // iterate over both lists simultaneously using indices
    // Note: Ensure the lists are the same size to avoid index out of bounds
    for(i <- primes.indices){
      val primeNumber: Int = primes.apply(i)
      val primeSquared: Int = primesSquared.apply(i)
      println("index " + i + ": " + primeNumber + " squared is " + primeSquared)
    }


  }

  def main(args: Array[String]): Unit = {
    listExample()
  }


}
