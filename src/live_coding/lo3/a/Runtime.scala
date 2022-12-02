package live_coding.lo3.a

import scala.annotation.tailrec

object Runtime {

  def timeFunction(f: () => Unit): Unit = {
    val startTime = System.currentTimeMillis()

    f()

    val totalTime = System.currentTimeMillis() - startTime

    println(totalTime.toString + " ms")
  }

  def listExample(): List[Double] = {
    var myList: List[Double] = List()
    val n: Int = 10000000
    for (i <- 0 until n) {
      myList ::= Math.random()
    }

    val sortedList: List[Double] = myList.sorted

    sortedList
  }

  def binarySearch(myArray: Array[Double], toFind: Double): Unit = {
    binarySearchHelper(myArray, toFind, 0, myArray.length - 1)
  }

  @tailrec
  def binarySearchHelper(myArray: Array[Double], toFind: Double, lowerIndex: Int, upperIndex: Int): Unit = {
    val epsilon: Double = 0.00000001

    val mid: Int = (lowerIndex + upperIndex) / 2
    val valueToCheck: Double = myArray(mid)
    if (Math.abs(valueToCheck - toFind) < epsilon) {
      println("found the thing at index " + mid + " it's: " + valueToCheck)
    } else if (upperIndex - lowerIndex == 1) {
      println("didn't find the thing")
    } else if (valueToCheck < toFind) {
      binarySearchHelper(myArray, toFind, mid, upperIndex)
    } else {
      binarySearchHelper(myArray, toFind, lowerIndex, mid)
    }
  }

  def linearSearch(myArray: Array[Double], toFind: Double): Unit = {
    val epsilon: Double = 0.00000001

    for (i <- myArray.indices) {
      if (Math.abs(myArray(i) - toFind) < epsilon) {
        println("found the thing at index " + i + " it's: " + myArray(i))
        return
      }
    }
    println("didn't find the thing")

  }

  def setExample(): Unit = {
    var mySet: Set[Int] = Set(1,2,3,3)
    println(mySet)
    println(mySet.contains(2))
    mySet += 10
    println(mySet)

  }

  def main(args: Array[String]): Unit = {
//    val myArray: Array[Double] = listExample().toArray
//    println("running linear search")
//    timeFunction(() => linearSearch(myArray, 0.1))
//    println("running binary search")
//    timeFunction(() => binarySearch(myArray, 0.1))

    timeFunction(setExample)

  }


}
