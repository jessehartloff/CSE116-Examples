package archived.live_coding.recursion

object BinaryConversions {

  /***
   * Converts decimal numbers to binary strings. No negative inputs
   *
   * Example: 10 -> "1010"
   * Example: 16 -> "10000"
   *
   * @param decimal The decimal number as an Int
   * @return The binary representation of the input as a String containing 1's and 0's
   */
  def decimalToBinary(decimal: Int): String ={
    if(decimal == 0){
      "0"
    }else if(decimal == 1){
      "1"
    }else{
      if(decimal % 2 ==0){
        // even
        // 10/"1010"
        // 5/"101" + "0"
        decimalToBinary(decimal / 2) + "0"
      } else{
        // odd
        // 5/"101"
        // 2/"10" + "1"
        decimalToBinary(decimal / 2) + "1"
      }
    }
  }

  /***
   * Converts binary strings to decimal numbers
   *
   * Example: "1010" -> 10
   * Example: "10000" -> 16
   *
   * @param binary The binary representation of a number as a String
   * @return The decimal number represented by the input as an Int
   */
  def binaryToDecimal(binary: String): Int ={
    if(binary.isEmpty){
      0
    }else if(binary.length == 1){
      // "1" of "0"
      binary.toInt
    }else{
      if(binary.charAt(binary.length - 1) == '0'){
        // even
        // "1010"/10
        // "101"/5
        binaryToDecimal(binary.substring(0, binary.length - 1)) * 2
      }else{
        // odd
        // "101"/5
        // "10"/2
        binaryToDecimal(binary.substring(0, binary.length - 1)) * 2 + 1
      }
    }
  }

}
