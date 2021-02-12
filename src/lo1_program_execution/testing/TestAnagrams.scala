package lo1_program_execution.testing

import org.scalatest._
import lo1_program_execution.objects.Anagrams

class TestAnagrams extends FunSuite {


  test("check anagrams"){

    val testCases: Map[String, List[String]] = Map(
      "" -> List(),
      "a" -> List("a"),
      "cse" -> List("cse","ces", "sec", "sce","esc", "ecs"),
      "off" -> List("off", "fof", "ffo"),
      "eeeeee" -> List("eeeeee"),
      "oop" -> List("oop", "opo", "poo"),
      "ooooo" -> List("ooooo"),
      "was" -> List("was", "wsa", "saw", "swa", "aws", "asw")
    )

    for((input, output) <- testCases){
      assert(Anagrams.anagrams(input).sorted == output.sorted, input)
    }

  }

}
