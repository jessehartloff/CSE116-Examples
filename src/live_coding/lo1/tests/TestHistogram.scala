package live_coding.lo1.tests

import org.scalatest._
import live_coding.lo1.Numbers

class TestHistogram extends FunSuite {

  test("test histograms") {

    val testCases: Map[List[Int], Map[Int, Int]] = Map(
      List(1, 2, 3) -> Map(1 -> 1, 2 -> 1, 3 -> 1),
      List(3, 1, 2, 2, 3, 1, 1) -> Map(1 -> 3, 2 -> 2, 3 -> 2),
      List(1, 1, 1, 1, 1, 1, 1) -> Map(1 -> 7),
      List(1, 1, -1, 1, -1, -1, 1) -> Map(1 -> 4, -1 -> 3),
      List() -> Map(),
      List(100) -> Map(100 -> 1)
    )

    for((input, expectedOutput) <- testCases){
      val actualOutput: Map[Int, Int] = Numbers.histogram(input)
      assert(actualOutput == expectedOutput)
    }
  }
}
