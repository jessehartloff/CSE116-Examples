package archived.live_coding.fp

import org.scalatest._

class TestHistogram extends FunSuite {

  test("Test Histogram") {

    val testCases: Map[List[Int], Map[Int, Int]] = Map(
      List(1, 2, 3, 4) -> Map(1 -> 1, 2 -> 1, 3 -> 1, 4 -> 1),
      List(4, 1, 2, 4, 2, 3, 1, 4, 1, 4, 4) -> Map(1 -> 3, 2 -> 2, 3 -> 1, 4 -> 5),
      List() -> Map(),
      List(5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5) -> Map(5 -> 20),
      List(-1024) -> Map(-1024 -> 1),
      List(1111111111, 2, 1, 5) -> Map(2 -> 1, 1 -> 1, 5 -> 1, 1111111111 -> 1),
      List(1, 2, 3, 4, 4, 4, 4, 5) -> Map(1 -> 1, 2 -> 1, 3 -> 1, 4 -> 4, 5 -> 1),
      List(1, 4, -2, 0, 3, -4, -4, 4, -4, 5, 0) -> Map(1 -> 1, -2 -> 1, 3 -> 1, 4 -> 2, -4 -> 3, 0 -> 2, 5 -> 1),
      List(0, 10, 3, 5) -> Map(0 -> 1, 10 -> 1, 3 -> 1, 5 -> 1)
    )

    for ((input, expectedOutput) <- testCases) {
      assert(Functions.histogram(input) == expectedOutput, input)
    }

  }


}
