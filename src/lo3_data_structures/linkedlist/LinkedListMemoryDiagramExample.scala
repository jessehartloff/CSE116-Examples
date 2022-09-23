package lo3_data_structures.linkedlist

object LinkedListMemoryDiagramExample {

  def main(args: Array[String]): Unit = {

    var myList: LLNode[Int] = new LLNode[Int](1, null)
    myList = new LLNode[Int](3, myList)
    myList = new LLNode[Int](5, myList)

    val theValue: Int = myList.next.next.value
    println("theValue: " + theValue)

    val listSize: Int = myList.size()
    println("size: " + listSize)
  }

}
