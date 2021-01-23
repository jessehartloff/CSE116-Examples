package lo1_program_execution.objects

object ObjectMain {

  def main(args: Array[String]): Unit = {
    println(ObjectWithState.x)
    ObjectWithState.doubleX()
    println(ObjectWithState.x)
  }

}
