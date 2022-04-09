package live_coding.lo3.tests

import live_coding.lo3.NumberGuesser
import org.scalatest._

class TestNumberGuesser extends FunSuite {

  val epsilon: Double = 0.01

  def compareDoubles(d1: Double, d2: Double): Boolean = {
    Math.abs(d1 - d2) < epsilon
  }

  def checkGuesser(lower: Double, upper: Double, numberToGuess: Double): Unit = {
    val guessingFunction: Double => Boolean = (guessedNumber: Double) => numberToGuess > guessedNumber
    val actual = NumberGuesser.guessTheNumber(lower, upper, guessingFunction)
    println("expected: " + numberToGuess + "  | computed: " + actual)
    assert(compareDoubles(actual, numberToGuess), "expected: " + numberToGuess + "  | computed: " + actual)
  }

  test("numbers from 0 to 100") {

    val numberToGuess: List[Double] = List(0.0, 100.0, 50.0, 55.55, 12.79, 0.15, 99.96666)

    val lower = 0.0
    val upper = 100.0
    for(number <- numberToGuess){
      checkGuesser(lower, upper, number)
    }
  }

}
