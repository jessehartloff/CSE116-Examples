package lo1_program_execution.recursion

object Recursion {

  def sumToN(n: Int): Int ={
    if(n <= 0){
      0
    }else{
      n + sumToN(n - 1)
    }
  }

  def main(args: Array[String]): Unit = {
    val result: Int = sumToN(3)
    println(result)
  }

}
