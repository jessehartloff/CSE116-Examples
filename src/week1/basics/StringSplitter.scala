package week1.basics

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

  def main(args: Array[String]): Unit = {
    val testInput = "true;false;true;true;true"
    // expecting 0.8
    val percentTrue = computePercentTrue(testInput)
    println("Percentage true == " + percentTrue)
  }

}
