package lo3_fp.recursion

object Permutations {

  def allPermutations(alphabet: List[String], length: Int): List[String] = {
    if (length == 0) {
      List("")
    }else {
      (for(s <- allPermutations(alphabet, length - 1)) yield {
        alphabet.map(s + _)
      }).flatten
    }
  }

  def main(args: Array[String]): Unit = {
    allPermutations(List("0", "1"), 4).foreach(println)
  }

}
