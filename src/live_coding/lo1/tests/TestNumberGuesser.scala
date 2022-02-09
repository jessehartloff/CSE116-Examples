package live_coding.lo1.tests

import live_coding.lo1.functions.NumberGuesser
import org.scalatest._

class TestNumberGuesser extends FunSuite {

  val epsilon: Double = 0.01

  def compareDoubles(d1: Double, d2: Double): Boolean = {
    Math.abs(d1 - d2) < epsilon
  }

  def checkGuesser(lower: Double, upper: Double, numberToGuess: Double): Unit = {
    val guessingFunction: Double => Boolean = (guessedNumber: Double) => numberToGuess > guessedNumber
    val actual = NumberGuesser.guessTheNumber(lower, upper, guessingFunction)
    assert(compareDoubles(actual, numberToGuess), "expected: " + numberToGuess + "  | computed: " + actual)
  }

  test("numbers from 0 to 100") {

  }

  test("numbers from -1000 to 1000") {

  }

}
