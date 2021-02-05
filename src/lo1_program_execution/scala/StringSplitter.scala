package lo1_program_execution.scala

object StringSplitter {

  def computePercentTrue(line: String): Double = {
    val splits: Array[String] = line.split(";")
    var totalCount: Double = 0
    var trueCount: Double = 0
    for (value <- splits) {
      val valueAsBoolean: Boolean = value.toBoolean
      if (valueAsBoolean) {
        trueCount += 1
      }
      totalCount += 1
    }
    trueCount / totalCount
  }

  def computePercentTrueAlternative(line: String): Double = {
    // There are many to solve this, or any, problem
    // Here is one alternative using Scala's loop filter
    val splits: Array[String] = line.split(";")
    var trueCount: Double = 0
    for (value <- splits if value.toBoolean) {
      trueCount += 1
    }
    trueCount / splits.length
  }

  def accessSplitsExample(): Unit = {
    val stringToSplit: String = "value1_value2_value3"

    // Split the String on "_"
    val splits: Array[String] = stringToSplit.split("_")

    // Access the first value
    val firstValue: String = splits(0)

    // Access the second value
    val secondValue: String = splits(1)

    // Access the third value
    val thirdValue: String = splits(2)

    println(firstValue)
    println(secondValue)
    println(thirdValue)
  }

  def main(args: Array[String]): Unit = {
    val testInput = "true;false;true;true;true"
    // expecting 0.8
    val percentTrue = computePercentTrue(testInput)
    println("Percentage true == " + percentTrue)
    accessSplitsExample()
  }

}
