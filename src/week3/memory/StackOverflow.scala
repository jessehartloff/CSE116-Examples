package week3.memory

object StackOverflow {

  def computeGeometricSum(n: Int): Int ={
    // Infinite recursion
    // Uncomment conditional for fix stack overflow
//    if(n>0) {
      var result: Int = computeGeometricSum(n - 1)
      result += n
      result
//    }else{
//      0
//    }
  }

  def main(args: Array[String]): Unit = {
    val result: Int = computeGeometricSum(3)
    println(result)
  }

}
