package archived.live_coding.recursion

import org.scalatest._

class TestBinaryConversions extends FunSuite {

  test("Test Decimal to Binary") {

    val testCases: Map[Int, String] = Map(
      10 -> "1010",
      16 -> "10000",
      1 -> "1",
      0 -> "0",
      255 -> "11111111",
      256 -> "100000000",
      7 -> "111",
      895698010 -> "110101011000110100010001011010"
    )

    for ((input, output) <- testCases) {
      val computedOutput = BinaryConversions.decimalToBinary(input)
      assert(computedOutput == output, input.toString + " -> " + computedOutput)
    }

  }


  test("Test Binary to Decimal") {
    val testCases: Map[String, Int] = Map(
      "1010" -> 10,
      "10000" -> 16,
      "1" -> 1,
      "0" -> 0,
      "" -> 0,
      "11111111" -> 255,
      "100000000" -> 256,
      "0000111" -> 7,
      "000110101011000110100010001011010" -> 895698010
    )

    for ((input, output) <- testCases) {
      val computedOutput = BinaryConversions.binaryToDecimal(input)
      assert(computedOutput == output, input + " -> " + computedOutput)
    }


  }


}
