package lo1_program_execution.scala

object DataStructures {

  def arrayMethods(): Unit = {
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

    // Iterate over indices using to which includes the endpoint
    for (index <- 0 to (arr.length-1)) {
      println("The value at index " + index + " is " + arr(index))
    }

    // Iterate over indices using until which excludes the endpoint
    for (index <- 0 until arr.length) {
      println("The value at index " + index + " is " + arr(index))
    }

    // Iterate over indices using .indices
    for (index <- arr.indices) {
      println("The value at index " + index + " is " + arr(index))
    }
  }

  def listMethods(): Unit = {
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

  def mapMethods(): Unit = {
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
    arrayMethods()
    listMethods()
    mapMethods()
  }

}
