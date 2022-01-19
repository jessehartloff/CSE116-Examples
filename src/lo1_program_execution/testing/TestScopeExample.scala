package lo1_program_execution.testing

import lo1_program_execution.memory.VariableScopeExample
import org.scalatest._

class TestScopeExample extends FunSuite {


  test("test isNegative method"){

    val testCases: Map[Int, Boolean] = Map(
      Integer.MAX_VALUE -> false,
      9001 -> false,
      111 -> false,
      10 -> false,
      2 -> false,
      1 -> false,
      0 -> false, // argue in the comments
      -1 -> true,
      -2 -> true,
      -20 -> true,
      -50 -> true,
      -100 -> true,
      -123 -> true,
      -999 -> true,
      -1000 -> true,
      Integer.MIN_VALUE -> true,
    )

    for((input, output) <- testCases){
      val computed: Boolean = VariableScopeExample.isNegative(input)
      assert(computed == output, input)
    }

  }

  test("test subtract method"){

    val testCases: Map[List[Int], Int] = Map(
      List(8, 3) -> 5,
      List(10, 4) -> 6,
      List(20, 20) -> 0,
      List(0, 8) -> -8,
      List(8, 0) -> 8,
      List(-10, 10) -> -20,
      List(-10, -5) -> -5,
      List(-10, -10) -> 0,
      List(-10, -20) -> 10,
      List(0, 0) -> 0,
      List(100, -55) -> 155
    )

    for((inputs, output) <- testCases){
      val computed: Int = VariableScopeExample.subtract(inputs.head, inputs(1))
      assert(computed == output, inputs.toString() + " -> " + computed)
    }

  }

  test("test divide method"){

    val testCases: Map[List[Int], Int] = Map(
      List(8, 4) -> 2,
      List(55, 5) -> 11,
      List(20, 20) -> 1,
      List(0, 8) -> 0,
      List(8, 1) -> 8,
      List(-10, 10) -> -1,
      List(10, -10) -> -1,
      List(-10, -10) -> 1,
      List(-10, -5) -> 2,
      List(256, 2) -> 128,

      // check for integer division
      List(100, 11) -> 9,
      List(5, 2) -> 2,
      List(20, 6) -> 3,
      List(-20, 6) -> -3,
      List(200, 203) -> 0,
      List(0, 1) -> 0,
      List(-17, 15) -> -1
    )

    for((inputs, output) <- testCases){
      val computed: Int = VariableScopeExample.divide(inputs.head, inputs(1))
      assert(computed == output, inputs.toString() + " -> " + computed)
    }


  }

  test("test factorial method"){

    val testCases: Map[Int, Int] = Map(
      0 -> 1,
      1 -> 1,
      2 -> 2,
      3 -> 6,
      4 -> 24,
      5 -> 120,
      6 -> 720,
      7 -> 5040,
      8 -> 40320,
      9 -> 362880,
      10 -> 3628800,
      11 -> 39916800,
      12 -> 479001600,
    )

    for((input, output) <- testCases){
      val computed: Int = VariableScopeExample.factorial(input)
      assert(computed == output, input)
    }

  }


  test("test permutation method"){

    val testCases: Map[List[Int], Int] = Map(
      List(1, 0) -> 1,
      List(1, 1) -> 1,

      List(2, 0) -> 1,
      List(2, 1) -> 2,
      List(2, 2) -> 2,

      List(3, 0) -> 1,
      List(3, 1) -> 3,
      List(3, 2) -> 6,
      List(3, 3) -> 6,

      List(4, 0) -> 1,
      List(4, 1) -> 4,
      List(4, 2) -> 12,
      List(4, 3) -> 24,
      List(4, 4) -> 24,

      List(5, 0) -> 1,
      List(5, 1) -> 5,
      List(5, 2) -> 20,
      List(5, 3) -> 60,
      List(5, 4) -> 120,
      List(5, 5) -> 120,

      List(10, 8) -> 1814400,
    )

    for((inputs, output) <- testCases){
      val computed: Int = VariableScopeExample.permute(inputs.head, inputs(1))
      assert(computed == output, inputs.toString() + " -> " + computed)
    }

  }

}
