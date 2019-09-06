package week1.basics

object DataStructures {

  def arrayExample(): Unit = {
    // Create new Array of Int
    val arr: Array[Int] = Array(2, 3, 4)

    // Change a value by index
    arr(1) = 20

    // Access a value by index
    val x: Int = arr(1)

    // Iterate over elements
    for (element <- arr) {
      println(element)
    }

    // Iterate over indices
    for (index <- 0 to arr.length) {
      println(index)
    }

    // Iterate over indices - alternate
    for (index <- arr.indices) {
      println(index)
    }
  }

  def listExample(): Unit = {
    // Create new Array of Int
    var list: List[Int] = List(2, 3, 4)

    // Access the first element
    val x: Int = list.head

    // Access a value by position
    val y: Int = list.apply(1)

    // Add an element to the end of the list (append)
    list = list :+ 50

    // Add an element to the beginning of the list (prepend)
    list = 70 :: list

    // Iteration
    for (element <- list) {
      println(element)
    }
  }

  def mapExample(): Unit = {
    // Create new Map of Int to Int
    var myMap: Map[Int, Int] = Map(2 -> 4, 3 -> 9, 4 -> 16)

    // Add an key-value pair
    myMap = myMap + (5 -> 25)

    // Access a value by key (Crashes if key not in map)
    val x: Int = myMap(3)

    // Access a value by key with default value if key not in map
    val y: Int = myMap.getOrElse(100, -1)

    // Iteration
    for ((key, value) <- myMap) {
      println("value " + value + " stored at key " + key)
    }
  }

  def main(args: Array[String]): Unit = {
    arrayExample()
    listExample()
    mapExample()
  }

}
