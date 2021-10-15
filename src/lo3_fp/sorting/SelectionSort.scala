package lo3_fp.sorting

import lo3_fp.sorting.inheritance.{Animal, Cat, Dog}

object SelectionSort {

  def intSelectionSort(inputData: List[Int], comparator: (Int, Int) => Boolean): List[Int] = {

    // copy only the reference of the input
    var data: List[Int] = inputData

    for (i <- data.indices) {

      // find the min value/index from i to the end of the list
      var minFound = data.apply(i)
      var minIndex = i
      for (j <- i until data.size) {
        val currentValue = data.apply(j)

        // make decisions based on the given comparator (this function can be thought of as a less than operator)
        if (comparator(currentValue, minFound)) {
          minFound = currentValue
          minIndex = j
        }
      }

      // swap the value at i with the min value
      data = data.updated(minIndex, data.apply(i))
      data = data.updated(i, minFound)
    }

    // return the new list
    data
  }

  def intSortingExample(): Unit = {
    val numbers = List(5, -23, -8, 7, -4, 10)
    val numbersSorted = intSelectionSort(numbers, (a: Int, b: Int) => a > b)
    println(numbersSorted)
  }


  def genericSortingExample(): Unit = {
    val animals: List[Animal] = List(new Cat("morris"), new Dog("Finn"), new Dog("Snoopy"), new Cat("Garfield"))
    val animalsSorted = selectionSort(animals, Animal.compareAnimals)
    println(animalsSorted)
  }


  def selectionSort[Type](inputData: List[Type], comparator: (Type, Type) => Boolean): List[Type] = {
    var data: List[Type] = inputData
    for (i <- data.indices) {
      var minFound = data.apply(i)
      var minIndex = i
      for (j <- i until data.size) {
        val currentValue = data.apply(j)
        if (comparator(currentValue, minFound)) {
          minFound = currentValue
          minIndex = j
        }
      }
      data = data.updated(minIndex, data.apply(i))
      data = data.updated(i, minFound)
    }
    data
  }

  def noVarSelectionSort[T](inputData: List[T], comparator: (T, T) => Boolean): List[T] = {
    noVarSelectionSortHelper(List(), inputData, comparator)
  }

  def noVarSelectionSortHelper[T](accumulator: List[T], remainingData: List[T], comparator: (T, T) => Boolean): List[T] = {
    if(remainingData.isEmpty){
      accumulator.reverse
    }else{
      val minValue = remainingData.reduce((acc: T, element:T) => if(comparator(acc, element)) acc else element)
      val newList = removeFirstOccurrence(List(), remainingData, minValue, comparator)
      noVarSelectionSortHelper(minValue :: accumulator, newList, comparator)
    }
  }

  def removeFirstOccurrence[T](before: List[T], after: List[T], toRemove: T, comparator: (T, T) => Boolean): List[T] = {
    if(!comparator(toRemove, after.head) && ! comparator(after.head, toRemove)){
      before.reverse ::: after.drop(1)
    }else{
      removeFirstOccurrence(after.head :: before, after.drop(1), toRemove, comparator)
    }
  }

  def largeExample(n: Int): Unit = {

    // Sort random doubles in the range -0.5 - 0.5 by absolute value
    val numbers: List[Double] = (for (_ <- 0 until n) yield Math.random() - 0.5).toList

    val start = System.nanoTime()
    val sortedNumbers = noVarSelectionSort(numbers, (x: Double, y: Double) => x.abs > y.abs)
    val totalTime = (System.nanoTime() - start) / 1000000.0

    sortedNumbers.foreach(println)
    println(f"\nSorting took $totalTime%1.2f ms")
  }

  def main(args: Array[String]): Unit = {
    intSortingExample()
    genericSortingExample()
    largeExample(10)
  }

}
