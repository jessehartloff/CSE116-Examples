package lo4_data_structures.trees

class BTNode[A](var value: A, var left: BTNode[A], var right: BTNode[A])

object MemoryDiagramExample {

  def traversal[A](node: BTNode[A]): Unit = {
    if (node != null) {
      traversal(node.left)
      traversal(node.right)
      print(node.value + " ")
    }
  }

  def main(args: Array[String]): Unit = {
    val root = new BTNode("life", null, null)
    root.left = new BTNode("Scala", null, null)
    root.right = new BTNode("for", null, null)
    root.right.left = new BTNode("coding", null, null)
    traversal(root)
  }

}
