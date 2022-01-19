package lo4_data_structures.linkedlist

object LiveCoding {

  def timeFunction(f: () => Unit): Unit = {
    val startTime = System.currentTimeMillis()

    f()

    val totalTime = System.currentTimeMillis() - startTime

    println(totalTime.toString + " ms")
  }


  def randomList(n: Int): List[Int] = {
    var list: List[Int] = List()
    for (i <- 0 until n) {
      list = Math.floor(Math.random() * 100.0).intValue() :: list
    }


    for (i <- list.iterator) {
      if (Math.random() < 0.001) {
//        println(i)
      }
//      list.apply(i)
    }
    list
  }

  def reduceExample(): Unit = {
    val numbers = randomList(100000)
    //    println(numbers)
    //    val result = numbers.reduce((a: Int, b: Int) => a.min(b))
    //    println(result)
  }


  def main(args: Array[String]): Unit = {
    timeFunction(reduceExample)
  }


}
