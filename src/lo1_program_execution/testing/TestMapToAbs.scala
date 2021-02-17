package lo1_program_execution.testing

import lo1_program_execution.scala.{MapExample, StringSplitter}
import org.scalatest._

class TestMapToAbs extends FunSuite {


  test("Test creation of a map that maps Ints to their absolute value") {

    val input: List[Int] = List(1, 2, -3)
    val expectedOutput: Map[Int, Int] = Map(1 -> 1, 2 -> 2, -3 -> 3)

    val computedOutput: Map[Int, Int] = MapExample.mapInputToAbs(input)

    assert(computedOutput.equals(expectedOutput))

  }


}
