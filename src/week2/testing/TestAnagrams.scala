package week2.testing

import org.scalatest._
import week2.objects.Anagrams

class TestAnagrams extends FunSuite {


  test("check anagrams"){

    val testCases: Map[String, List[String]] = Map(
      "" -> List(),
      "a" -> List("a"),
      "cse" -> List("cse","ces", "sec", "sce","esc", "ecs"),
      "off" -> List("off", "fof", "ffo"),
      "eeeeee" -> List("eeeeee")
    )

    for((input, output) <- testCases){
      assert(Anagrams.anagrams(input).sorted == output.sorted, input)
    }

  }

}
