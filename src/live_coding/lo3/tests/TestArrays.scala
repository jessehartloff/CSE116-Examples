package live_coding.lo3.tests

import live_coding.lo3.{ArrayExamples, NumberGuesser}
import org.scalatest._

class TestArrays extends FunSuite {


  test("test sum of Array of Ints") {

    val testCases: Map[Array[Int], Int] = Map(
      Array(1, 2, 3) -> 6,
      Array(5, 5, 5, 5) -> 20,
      Array(5, 5, 5, 5, 5) -> 25,
      Array(5, 5, 5, 5, 1) -> 21,
      Array(5, 5, 5) -> 15,
      Array(5, 5, 5, 5, 2) -> 22,
      Array(5, 5) -> 10,
      Array(5, 6) -> 11,
      Array(5, 5, 5, 5, 10) -> 30,
      Array(5) -> 5,
      Array() -> 0,
      Array(-5, -5) -> -10,
      Array(0) -> 0,
      Array(0, 0, 0, 0, 0, 0, 0, 0, 0) -> 0
    )

    for ((input, expectedOutput) <- testCases) {
      val actual: Int = ArrayExamples.sum(input)
      assert(actual == expectedOutput)
    }
  }


  test("test contains for Array of Ints") {
    val testCases: List[ContainsTestCase] = List(
      new ContainsTestCase(Array(1, 2, 3), 6, false),
      new ContainsTestCase(Array(1, 2, 3), 2, true),
      new ContainsTestCase(Array(3, 3, 3), 3, true),
      new ContainsTestCase(Array(1, 2, 3), -2, false),
      new ContainsTestCase(Array(), 2, false),
      new ContainsTestCase(Array(-20), -20, true)
    )

    for (testCase <- testCases) {
      assert( ArrayExamples.contains(testCase.data, testCase.toFind) == testCase.expected)
    }

  }

}

class ContainsTestCase(val data: Array[Int], val toFind: Int, val expected: Boolean)