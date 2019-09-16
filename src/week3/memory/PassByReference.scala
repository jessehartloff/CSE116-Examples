package week3.memory

object PassByReference {

  def addToState(input: ClassWithState): Unit = {
    input.state += 1
  }

  def main(args: Array[String]): Unit = {
    val data: ClassWithState = new ClassWithState(0)
    addToState(data)
    println(data.state)
  }

}
