package week3.memory

class CompilerError(var state: Int) {

  def addToState(toAdd: Int): Unit ={
    this.state += toAdd
  }

}


object CompilerError {
  def main(args: Array[String]): Unit = {
    val exampleObject = new CompilerError(5)
    exampleObject.addToState(10)

//  compiler error with this line. Code will not run at all
//    exampleObject.addToState("ten")

    println(exampleObject.state)
  }
}

//example_object = RuntimeErrorExample(5)
//example_object.add_to_state(10)
//print(example_object.state)
