package live_coding.lo1.tests

import live_coding.lo1.Numbers
import org.scalatest._

class TestMostFrequent extends FunSuite {

  test("test most frequent") {
    val testCases: Map[List[Int], List[Int]] = Map(
      List(1, 2, 3) -> List(1, 2, 3),
      List(3, 1, 2, 1, 1, 2, 3) -> List(1),
      List() -> List(),
      List(0, 0, 0) -> List(0),
      List(1, 1, -1, -1, 1) -> List(1)
    )

    for ((input, expectedOutput) <- testCases) {
      val actualOutput: List[Int] = Numbers.mostFrequent(input)
      assert(actualOutput.sorted == expectedOutput.sorted)
    }
  }

}
