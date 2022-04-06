package live_coding.lo3.tests

import live_coding.lo3.Histogram
import org.scalatest._

class TestHistogram extends FunSuite {

  test("test histograms") {
    val testCases: Map[List[Int], Map[Int, Int]] = Map(
      List(1,2,3) -> Map(1->1, 2->1, 3->1),
      List(3,1,3,3,3,2,3,3) -> Map(1->1, 2->1, 3->6),
      List(3,-1,-3,3,-3,2,3,-3) -> Map(-1->1, 2->1, 3->3, -3->3),
      List(1000) -> Map(1000->1),
      List(-1000, -1000, 1000, 0, -100) -> Map(1000->1, -1000->2, 0->1,-100->1),
      List(0) -> Map(0->1),
      List() -> Map()
    )

    for((input, expectedOutput) <- testCases){
      println(input)
      assert(Histogram.histogram(input) == expectedOutput, input)
    }
  }
}
