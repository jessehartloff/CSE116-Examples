package lo3_fp.recursion

import org.scalatest.FunSuite

class TestAnagrams extends FunSuite {
  test("Test Anagrams") {

    val testCases: Map[String, List[String]] = Map(
      "" -> List(),
      "a" -> List("a"),
      "fox" -> List("fox", "fxo", "xfo", "xof", "ofx", "oxf"),
      "off" -> List("off", "fof", "ffo"),
      "cse" -> List("cse", "ces", "ecs", "esc", "sec", "sce"),
      "oo" -> List("oo")
    )

    for ((input, expectedOutput) <- testCases) {
      assert(Anagrams.anagrams(input).sorted == expectedOutput.sorted, input)
    }

  }
}
