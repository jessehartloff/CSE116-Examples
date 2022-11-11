package lo3_data_structures.trees.bst

object BinarySearchTreeExample {

  def example(): Unit = {
    val bst = new BinarySearchTree[Int](new LessThanComparator())
    bst.insert(5)
    bst.insert(2)
    bst.insert(8)
    bst.insert(4)
    bst.insert(7)
    bst.insert(14)
    bst.insert(-3)

    bst.find(14)
  }


  def example2(): Unit = {
    val bst = new BinarySearchTree[Int](new LessThanComparator())
    bst.insert(-3)
    bst.insert(2)
    bst.insert(4)
    bst.insert(5)
    bst.insert(7)
    bst.insert(8)
    bst.insert(14)

    bst.find(14)
  }


  def main(args: Array[String]): Unit = {
    example()
    example2()
  }

}
