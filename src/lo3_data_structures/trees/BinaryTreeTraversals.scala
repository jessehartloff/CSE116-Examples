package lo3_data_structures.trees

object BinaryTreeTraversals {

  def inOrderTraversal[A](node: BinaryTreeNode[A]): Unit = {
    if(node != null) {
      inOrderTraversal(node.left)
      println(node.value)
      inOrderTraversal(node.right)
    }
  }

  def preOrderTraversal[A](node: BinaryTreeNode[A]): Unit = {
    if(node != null) {
      println(node.value)
      preOrderTraversal(node.left)
      preOrderTraversal(node.right)
    }
  }

  def postOrderTraversal[A](node: BinaryTreeNode[A]): Unit = {
    if(node != null) {
      postOrderTraversal(node.left)
      postOrderTraversal(node.right)
      println(node.value)
    }
  }


  def binaryTreeExamples():Unit={

    val root = new BinaryTreeNode[Int](5, null, null)
    root.left = new BinaryTreeNode[Int](2, null, null)
    root.right = new BinaryTreeNode[Int](8, null, null)
    root.left.left = new BinaryTreeNode[Int](-3, null, null)
    root.left.right = new BinaryTreeNode[Int](4, null, null)
    root.right.left = new BinaryTreeNode[Int](7, null, null)
    root.right.right = new BinaryTreeNode[Int](14, null, null)

    println("In-order Traversal:")
    inOrderTraversal(root)

    println("\nPre-order Traversal:")
    preOrderTraversal(root)

    println("\nPost-order Traversal:")
    postOrderTraversal(root)
  }

  def main(args: Array[String]): Unit = {
    binaryTreeExamples()
  }


}
