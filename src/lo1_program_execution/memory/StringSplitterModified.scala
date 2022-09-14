package lo1_program_execution.memory

class StringSplitterModified {

  def computePercentTrue(line: String): Double = {
    val splits: Array[String] = line.split(";")
    var trueCount: Double = 0.0
    for (value <- splits) {
      val valueAsBoolean: Boolean = value.toBoolean
      if (valueAsBoolean) {
        trueCount += 1.0
      }
    }
    val toReturn: Double = trueCount / splits.length
    toReturn
  }


  def main(args: Array[String]): Unit = {
    val testInput = "true;false"
    val percentTrue = computePercentTrue(testInput)
    println(percentTrue)
  }

}
