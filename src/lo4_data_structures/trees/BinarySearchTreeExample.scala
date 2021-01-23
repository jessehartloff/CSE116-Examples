package lo4_data_structures.trees

object BinarySearchTreeExample {

  def example(): Unit = {
    val intLessThan: (Int, Int) => Boolean = (a: Int, b: Int) => a < b
    val bst = new BinarySearchTree[Int](intLessThan)
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
    val intLessThan: (Int, Int) => Boolean = (a: Int, b: Int) => a < b
    val bst = new BinarySearchTree[Int](intLessThan)
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
