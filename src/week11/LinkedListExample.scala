package week11

import week11.equipment.{Equipment, Excavators, GoldMines, Shovels}

object LinkedListExample {

  def main(args: Array[String]): Unit = {

    // create the list [5, 3, 1] starting at the end and prepending each value
    var myList: LinkedListNode[Int] = new LinkedListNode[Int](1, null)
    myList = new LinkedListNode[Int](3, myList)
    myList = new LinkedListNode[Int](5, myList)

    // prints 1
    println(myList.next.next.value)


    myList = myList.prepend(10)
    myList = myList.prepend(11)
    myList = myList.prepend(12)

    println(myList)


    println(myList.apply(4).value)
    println(myList.find(5).value)
    println(myList.findIterative(5).value)


    val squareFunction = (x: Int) => x * x
    val newList = myList.map(squareFunction)
    println(newList)


//    equipmentExample()
  }


  def equipmentExample(): Unit  = {
    var equipmentList = new LinkedListNode[Equipment](new GoldMines(), null)
    equipmentList = equipmentList.prepend(new Excavators())
    equipmentList = equipmentList.prepend(new Shovels())

    val toCall = (equipment: Equipment) => equipment.buy()

//    equipmentList.foreach(toCall)
  }
}
