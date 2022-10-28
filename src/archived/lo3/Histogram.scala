package archived.lo3

import scala.annotation.tailrec

object Histogram {

  def histogram(data: List[Int]): Map[Int, Int] = {
    histogramHelper(data, Map())
  }

  @tailrec
  def histogramHelper(data: List[Int], accumulator: Map[Int, Int]): Map[Int, Int] = {
    if(data.isEmpty){
      accumulator
    }else{
      val element: Int = data.head
      val newAccumulator: Map[Int, Int] = if(accumulator.contains(element)){
        accumulator + (element -> (accumulator(element) + 1))
      }else{
        accumulator + (element -> 1)
      }
      histogramHelper(data.drop(1), newAccumulator)
    }
  }

}
