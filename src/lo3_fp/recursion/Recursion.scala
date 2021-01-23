package lo3_fp.recursion

object Recursion {


  def computeGeometricSum(n: Int): Int ={
    if(n <= 0){
      0
    }else{
      n + computeGeometricSum(n - 1)
    }
  }


  def main(args: Array[String]): Unit = {
    val result: Int = computeGeometricSum(3)
    println(result)
  }


}
