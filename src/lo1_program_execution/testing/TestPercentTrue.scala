package lo1_program_execution.testing

import lo1_program_execution.scala.{Conditional, StringSplitter}
import org.scalatest._

class TestPercentTrue extends FunSuite {

  val epsilon: Double = 0.0001

  def compareDoubles(d1: Double, d2: Double): Boolean = {
    Math.abs(d1 - d2) < epsilon
  }


  test("Test that string splitter returns the percentage of trues") {

    val testCases: Map[String, Double] = Map(
      "true;false;true;true;true" -> 0.8,
      "true;false;false" -> 0.33333,
      "true;true" -> 1.0,
      "false" -> 0.0,
      "true" -> 1.0
    )

    for ((input, expectedOutput) <- testCases) {
      val computedOutput: Double = StringSplitter.computePercentTrue(input)
      assert(compareDoubles(computedOutput, expectedOutput),
        "On input: " + input +
          " | expected: " + expectedOutput +
          " | computed: " + computedOutput
      )

    }


  }


}
