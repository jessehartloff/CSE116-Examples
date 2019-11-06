package week11

object LiveCoding {

  def timeFunction(f: () => Unit): Unit = {
    val startTime = System.currentTimeMillis()

    f()

    val totalTime = System.currentTimeMillis() - startTime

    println(totalTime + " ms")
  }


  def randomList(n: Int): List[Int] = {
    var l: List[Int] = List()
    for (_ <- 0 until n) {
      l ::= Math.floor(Math.random() * 100.0).intValue()
    }
    l
  }

  def reduceExample(): Unit = {
    val numbers = randomList(10000000)
//    println(numbers)
//    val result = numbers.reduce((a: Int, b: Int) => a.min(b))
//    println(result)
  }


  def main(args: Array[String]): Unit = {
    timeFunction(reduceExample)
  }


}
