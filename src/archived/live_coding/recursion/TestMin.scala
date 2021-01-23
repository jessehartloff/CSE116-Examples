package archived.live_coding.recursion

import org.scalatest._

class TestMin extends FunSuite {

  val EPSILON: Double = 0.0001

  test("Test Min of a Function") {
    val f1: Double => Double = (x: Double) => 3 * Math.pow(x, 2) + 4 * x - 2
    val expected1: Double = -2.0/3.0
    assert(Math.abs(Min.minOfFunction(f1) - expected1) < EPSILON)


    val f: Double => Double = (x: Double) => 4 * x - 2
    val expected: Double = Double.NegativeInfinity
    assert(Min.minOfFunction(f) == expected)
  }


}
