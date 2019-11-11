package week12

object ExpressionTree {

  def fullyParenthesizedInOrderTraversal[A](node: BinaryTreeNode[A], f: A => Unit): Unit = {
    if (node != null) {
      val operator = List("^", "*", "/", "+", "-").contains(node.value)
      if (operator) {
        print("(")
      }
      fullyParenthesizedInOrderTraversal(node.left, f)
      f(node.value)
      fullyParenthesizedInOrderTraversal(node.right, f)
      if (operator) {
        print(")")
      }
    }
  }

  def main(args: Array[String]): Unit = {

    val pow = (a: Double, b: Double) => Math.pow(a, b)
    val mul = (a: Double, b: Double) => a * b
    val div = (a: Double, b: Double) => a / b
    val add = (a: Double, b: Double) => a + b
    val sub = (a: Double, b: Double) => a - b

    val operatorTable: Map[String, (Double, Double) => Double] = Map(
      "^" -> pow,
      "*" -> mul,
      "/" -> div,
      "+" -> add,
      "-" -> sub
    )

    // infix: (12-4)-(8+9/3)
    val root: BinaryTreeNode[String] = new BinaryTreeNode[String]("-", null, null)

    root.left = new BinaryTreeNode[String]("-", null, null)
    root.left.left = new BinaryTreeNode[String]("12", null, null)
    root.left.right = new BinaryTreeNode[String]("4", null, null)

    root.right = new BinaryTreeNode[String]("+", null, null)
    root.right.left = new BinaryTreeNode[String]("8", null, null)
    root.right.right = new BinaryTreeNode[String]("/", null, null)
    root.right.right.left = new BinaryTreeNode[String]("9", null, null)
    root.right.right.right = new BinaryTreeNode[String]("3", null, null)


    println("\nInfix Notation:")
    fullyParenthesizedInOrderTraversal(root, print)


    println("\n\nPostfix Notation:")
    BinaryTreeTraversals.postOrderTraversal(root, (token: String) => print(token + " "))
  }


  def evaluateTree(node: BinaryTreeNode[String]) : Double = {

    0.0
  }

}
