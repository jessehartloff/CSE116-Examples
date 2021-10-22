package live_coding.tests

import live_coding.functions.Numbers
import org.scalatest._

class TestMostFrequent extends FunSuite {

  test("test most frequent") {

    val testCases: Map[List[Int], List[Int]] = Map(
      List(1,2,2,3) -> List(2),
      List(1,1,1,1) -> List(1),
      List(1,1,2,2,3,3) -> List(1,2,3),
      List(1,1,2,2,3,3,1) -> List(1),
      List(1,3,1,2,2,3,3,1) -> List(1,3)
    )

    for ((input, output) <- testCases) {
      assert(Numbers.mostFrequent(input).sorted == output.sorted, input)
    }

  }

}
