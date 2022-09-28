package lo1_program_execution.recursion

object MergeSort {

  def mergeSort(inputData: List[Double]): List[Double] = {
    if (inputData.length < 2) {
      inputData
    } else {
      val mid: Int = inputData.length / 2
      val (left, right) = inputData.splitAt(mid)
      val leftSorted = mergeSort(left)
      val rightSorted = mergeSort(right)

      merge(leftSorted, rightSorted)
    }
  }

  def merge(left: List[Double], right: List[Double]): List[Double] = {
    var leftPointer = 0
    var rightPointer = 0

    var sortedList: List[Double] = List()

    while (leftPointer < left.length && rightPointer < right.length) {
      if (left(leftPointer) < right(rightPointer)) {
        sortedList = sortedList :+ left(leftPointer)
        leftPointer += 1
      } else {
        sortedList = sortedList :+ right(rightPointer)
        rightPointer += 1
      }
    }

    while (leftPointer < left.length) {
      sortedList = sortedList :+ left(leftPointer)
      leftPointer += 1
    }
    while (rightPointer < right.length) {
      sortedList = sortedList :+ right(rightPointer)
      rightPointer += 1
    }

    sortedList
  }


  def runMergeSort(n: Int): Unit = {

    val numbers: List[Double] = (for (_ <- 0 until n) yield Math.random() - 0.5).toList

    val sortedNumbers = mergeSort(numbers)

    sortedNumbers.foreach(println)
  }


  def main(args: Array[String]): Unit = {
    runMergeSort(10)
  }

}
