package live_coding.lo1

object Numbers {

  /**
   * Computes a histogram of the given numbers.
   *
   * Ex. If the input is (1,4,2,2,3,1), the output is (1->2,2->2,3->1,4->1)
   *
   * @param data A list of numbers
   * @return A histogram indicated the number of times each Int appears in the provided list
   */
  def histogram(input: List[Int]): Map[Int, Int] = {
    var result: Map[Int, Int] = Map()
    for(value <- input){
      if(!result.contains(value)){
        result = result + (value -> 0)
      }
      result = result + (value -> (result(value) + 1))
    }
    result
  }


  /**
   * Returns the number(s) that appear most frequently in the given data. If multiple numbers
   * are tied for the most frequent, they should all be returned
   *
   * @param data A list of numbers
   * @return All of the most frequent numbers
   */
  def mostFrequent(data: List[Int]): List[Int] = {
    List()
  }
}
