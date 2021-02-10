package lo1_program_execution.scala

object MapExample {

  def mapExample(): Map[Int, String] = {
    var numberStrings: Map[Int, String] = Map(
      0 -> "zero",
      1 -> "one",
      2 -> "two",
      4 -> "four",
      5 -> "five"
    )

    println("1: " + numberStrings)

    // We missed three. Let's add a key-value pair to the map
    // Must reassign the numberStrings variable
    numberStrings = numberStrings + (3 -> "sixteen")

    // Can use shorthand syntax
    numberStrings += (6 -> "six")

    println("2: " + numberStrings)


    // Oop, 3 should not map to "sixteen"
    // Add the correct key-value pair
    numberStrings += (3 -> "three")

    // Cannot have duplicate keys in a map!
    // Adding a new pair with a key of 3 replaces (3 -> "sixteen")

    println("3: " + numberStrings)

    // remove a key-value pair by key
    numberStrings -= 0

    println("4: " + numberStrings)
    println()

    // iterate over key-value pairs
    // Note: There is no meaningful order in a map
    for((key, value) <- numberStrings){
      println("The key " + key + " maps to the value " + value)
    }

    println()

    numberStrings
  }

  def numberToString(referenceMap: Map[Int, String], number: Int): String = {
    referenceMap.getOrElse(number, "No conversion found")
  }


  // Takes a list and returns a map that maps the values of the list
  // to their absolute values
  def mapInputToAbs(input: List[Int]): Map[Int, Int] ={
    var output: Map[Int, Int] = Map()
    for(number <- input){
      output += number -> Math.abs(number)
    }
    output
  }

  def main(args: Array[String]): Unit = {
    val mapOfNumbers: Map[Int, String] = mapExample()
    println(numberToString(mapOfNumbers, 1))
    println(numberToString(mapOfNumbers, 2))
    println(numberToString(mapOfNumbers, 3))
    println(numberToString(mapOfNumbers, 50))

  }

}
