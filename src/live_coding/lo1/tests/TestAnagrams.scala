package live_coding.lo1.tests

import org.scalatest._
import live_coding.lo1.Anagrams

class TestAnagrams extends FunSuite {

  test("test anagrams") {

    val testCases: Map[String, List[String]] = Map(
      "tie" -> List("tie", "tei", "eit", "eti", "ite", "iet"),
      "il" -> List("il", "li"),
      "ill" -> List("ill", "lil", "lli"),
      "aaaaaaa" -> List("aaaaaaa"),
      "" -> List()
    )

    for((input, expectedOutput) <- testCases) {
      val actualOutput: List[String] = Anagrams.anagrams(input)
      assert(actualOutput.sorted == expectedOutput.sorted)
    }
  }

}
