package live_coding.tests

import live_coding.functions.Numbers
import org.scalatest._

class TestHistogram extends FunSuite {

  test("test histograms") {

    val testCases: Map[List[Int], Map[Int, Int]] = Map(
      List() -> Map(),
      List(1, 1, 2, 5, 5, 6, 6, 4, 2, 1) -> Map(1 -> 3, 2 -> 2, 4 -> 1, 5 -> 2, 6 -> 2),
      List(-4, -4, -4, -4, -4) -> Map(-4 -> 5),
      List(-4, -4, -4, 0, -4, -4) -> Map(0 -> 1, -4 -> 5),
      List(-1, 0, 1) -> Map(0 -> 1, -1 -> 1, 1 -> 1),
      List(-1, 0, 1, 0, -1) -> Map(0 -> 2, -1 -> 2, 1 -> 1),
      List(1) -> Map(1 -> 1)
    )

    for ((input, output) <- testCases) {
      assert(Numbers.histogram(input) == output, input)
    }

  }

}
