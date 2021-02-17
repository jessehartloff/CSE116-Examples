package lo1_program_execution.testing

import lo1_program_execution.objects.Anagrams
import org.scalatest._

class TestIsAnagram extends FunSuite {


  test("check if two strings are anagrams of each other"){

    val testCases: Map[List[String], Boolean] = Map(
      List("Astronomer", "Moon Starer") -> true,
      List("Astronomers", "Moon Starers") -> true,
      List("asdf", "fdsa") -> true,
      List("ASDf", "fsAd") -> true,
      List("Hart loff ", "  F  o r t  L a h    f ") -> true,
      List("Hartloff", "Fort Half") -> true,
      List("oop", "OPO") -> true,
      List("oop", "POO") -> true,
      List("ooooo", "ooooo") -> true,
      List("", "") -> true,
      List("oop", "POOO") -> false,
      List("oop", "POP") -> false,
      List("oop", "pop") -> false,
      List("oop", "POOO") -> false,
      List("oooo", "ooooo") -> false,
      List("", "a") -> false,
      List("licky charms", "charms lucky") -> false
    )

    for((inputs, expectedOutput) <- testCases){
      assert(Anagrams.isAnagram(inputs.head, inputs(1)) == expectedOutput, inputs)
    }



  }

}
