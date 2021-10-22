package live_coding.functions

object Numbers {

  def histogram(data: List[Int]): Map[Int, Int] = {
    if(data.isEmpty){
      Map()
    }else{
      val smallerHistogram: Map[Int, Int] = histogram(data.drop(1))
      val elementToProcess: Int = data.head
      if(smallerHistogram.contains(data.head)){
        smallerHistogram + (elementToProcess -> (smallerHistogram(elementToProcess) + 1))
      }else{
        smallerHistogram + (elementToProcess -> 1)
      }
    }
  }



  def mostFrequent(data: List[Int]): List[Int] = {
    val histo: Map[Int, Int] = histogram(data)
    val options = data.distinct
    val max = histo.values.max
    options.filter((i: Int) => histo(i) == max)
  }
}
