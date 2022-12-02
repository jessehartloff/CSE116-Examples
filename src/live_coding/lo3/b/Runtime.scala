package live_coding.lo3.b

object Runtime {

  def timeFunction(f: () => Unit): Unit = {
    val startTime = System.currentTimeMillis()

    f()

    val totalTime = System.currentTimeMillis() - startTime

    println(totalTime.toString + " ms")
  }


  def main(args: Array[String]): Unit = {

  }


}
