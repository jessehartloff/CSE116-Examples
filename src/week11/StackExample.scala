package week11

object StackExample {


  def usingOurStack(): Unit = {
    val stack = new Stack[Int]()
    stack.push(3)
    stack.push(7)
    stack.push(2)
    stack.push(-5)

    // stack is:
    // -5
    // 2
    // 7
    // 3

    val element = stack.pop()
    println(element)
    // element is -5

    println(stack.top)
    // stack is:
    // 2
    // 7
    // 3
  }

  def usingScalaStack(): Unit = {
    val stack = scala.collection.mutable.Stack[Int]()
    stack.push(3)
    stack.push(7)
    stack.push(2)
    stack.push(-5)

    val element = stack.pop()
  }


  def usingScalaList(): Unit = {
    var stack = List[Int]()
    stack = 3 :: stack
    stack = 7 :: stack
    stack = 2 :: stack
    stack = -5 :: stack

    val element = stack.head
    stack = stack.drop(1)
  }

  def main(args: Array[String]): Unit = {
    usingOurStack()
    usingScalaStack()
    usingScalaList()
  }

}
