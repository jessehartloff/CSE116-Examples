package archived.live_coding.fp

import org.scalatest._

class TestNumberGuesser extends FunSuite {

  val EPSILON: Double = 0.01

  def compareDoubles(d1: Double, d2: Double): Boolean = {
    (d1 - d2).abs < EPSILON
  }


  test("Test Histogram") {
    val min = -100.0
    val max = 100.0

    val inputs: List[Double] = List(0.0, 1.0, 50.0, -99.9, 99.9, -50, Math.PI, Math.E, -3.33333333, 56.342, 21.0)
    val allInputs: List[Double] = inputs ::: (for (_ <- 0 until 1000) yield {
      (Math.random() - 0.5) * 200.0
    }).toList

    for (input <- allInputs) {
      println("input: " + input)
      assert(compareDoubles(Functions.numberGuesser(min, max, (d: Double) => d < input), input), input)
    }
  }



}
