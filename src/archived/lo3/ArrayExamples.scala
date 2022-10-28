package archived.lo3

object ArrayExamples {

  def sum(data: Array[Int]): Int = {
    sumHelper(data, 0, 0)
  }

  def sumHelper(data: Array[Int], index: Int, total: Int): Int = {
    if(index == data.length){
      total
    }else{
      sumHelper(data, index + 1, data(index) + total)
    }
  }

  def contains(data: Array[Int], toFind: Int): Boolean = {
    false
  }

}
