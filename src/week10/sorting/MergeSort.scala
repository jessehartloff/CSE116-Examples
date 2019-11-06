package week10.sorting

import scala.collection.mutable.ListBuffer

object MergeSort {

  def mergeSort[T](inputData: List[T], comparator: (T, T) => Boolean): List[T] = {
    if (inputData.length < 2) {
      inputData
    } else {
      val mid: Int = inputData.length / 2
      val (left, right) = inputData.splitAt(mid)
      val leftSorted = mergeSort(left, comparator)
      val rightSorted = mergeSort(right, comparator)

      foreshadowMerge(leftSorted, rightSorted, comparator)
    }
  }

  // This method is given as an example, though it is very inefficient
  def merge[T](left: List[T], right: List[T], comparator: (T, T) => Boolean): List[T] = {
    var leftPointer = 0
    var rightPointer = 0

    var sortedList: List[T] = List()

    while (leftPointer < left.length && rightPointer < right.length) {
      if (comparator(left.apply(leftPointer), right.apply(rightPointer))) {
        sortedList = sortedList :+ left.apply(leftPointer)
        leftPointer += 1
      } else {
        sortedList = sortedList :+ right.apply(rightPointer)
        rightPointer += 1
      }
    }

    while (leftPointer < left.length) {
      sortedList = sortedList :+ left.apply(leftPointer)
      leftPointer += 1
    }
    while (rightPointer < right.length) {
      sortedList = sortedList :+ right.apply(rightPointer)
      rightPointer += 1
    }

    sortedList
  }

  // Same functionality as merge, but uses linked lists much more efficiently
  def foreshadowMerge[T](left: List[T], right: List[T], comparator: (T, T) => Boolean): List[T] = {

    if (left.length == 1 && right.length == 1) {
      if (comparator(left.head, right.head)) {
        List(left.head, right.head)
      } else {
        List(right.head, left.head)
      }
    } else {

      val leftIter = left.iterator
      val rightIter = right.iterator

      val sortedList: ListBuffer[T] = ListBuffer()

      var leftVal = leftIter.next
      var rightVal = rightIter.next

      var leftUpdated = false
      var rightUpdated = false

      while (leftIter.hasNext || rightIter.hasNext) {

        if (leftUpdated) {
          leftVal = leftIter.next
          leftUpdated = false
        }
        if (rightUpdated) {
          rightVal = rightIter.next
          rightUpdated = false
        }

        if (comparator(leftVal, rightVal)) {
          sortedList += leftVal
          if (!leftIter.hasNext) {
            sortedList += rightVal
            sortedList ++= rightIter
          } else {
            leftUpdated = true
          }
        } else {
          sortedList += rightVal
          if (!rightIter.hasNext) {
            sortedList += leftVal
            sortedList ++= leftIter
          } else {
            rightUpdated = true
          }
        }
      }
      sortedList.toList
    }
  }

  def largeExample(n: Int): Unit = {

    // Sort random doubles in the range -0.5 - 0.5 by absolute value
    val numbers: List[Double] = (for (_ <- 0 to n) yield Math.random() - 0.5).toList

    val start = System.nanoTime()
    val sortedNumbers = mergeSort(numbers, (x: Double, y: Double) => x.abs > y.abs)

    // switch merge sort with Scala's builtin algorithm for timing comparisons (The builtin should always be faster!)
    // Use the foreshadowMerge method for comparable times
    //    val sortedNumbers = numbers.sortWith((x: Double, y: Double) => x.abs > y.abs)

    val totalTime = (System.nanoTime() - start) / 1000000.0

    //    sortedNumbers.foreach(println)
    println(f"\nSorting took $totalTime%1.2f ms")
  }

  def main(args: Array[String]): Unit = {
    largeExample(2000)
  }

}
