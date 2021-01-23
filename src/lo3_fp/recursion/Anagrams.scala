package lo3_fp.recursion

object Anagrams {


  def anagrams(input: String): List[String] = {
    if (input.length == 1) {
      List(input)
    } else {
      val output: List[List[String]] = (for (i <- 0 until input.length) yield {
        val newString: String = input.substring(0, i) + input.substring(i + 1, input.length)
        anagrams(newString).map(_ + input.charAt(i))
      }).toList

      output.flatten.distinct
    }
  }


}
