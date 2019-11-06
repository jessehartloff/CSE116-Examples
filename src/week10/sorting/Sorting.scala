package week10.sorting

import week10.sorting.inheritance._


object Sorting {

  def defaultSort(): Unit = {
    val numbers = List(5, -23, -8, 7, -4, 10)
    // implicitly sorts by a default ordering
    val numbersSorted = numbers.sorted
    println(numbersSorted)
  }

  def sortByDerivedValue(): Unit = {
    val numbers = List(5, -23, -8, 7, -4, 10)
    // sort by the result of a method (like setting the key in Python sorting)
    val numbersSorted = numbers.sortBy(Math.abs)
    println(numbersSorted)
  }


  def sortWithComparator(): Unit = {
    val numbers = List(5, -23, -8, 7, -4, 10)
    // sort by a comparator function/method. This function sorts in decreasing order
    val comparator: (Int, Int) => Boolean = (a: Int, b: Int) => a > b
    val numbersSorted = numbers.sortWith(comparator)
    // can be shortened to - numbers.sortWith(_ > _)
    println(numbersSorted)
  }

  def sortCustomType(): Unit = {
    val animals: List[Animal] = List(new Cat("morris"), new Dog("Finn"), new Dog("Snoopy"), new Cat("Garfield"))
    val animalsSorted = animals.sortWith(Animal.compareAnimals)
    println(animalsSorted)
  }


  def main(args: Array[String]): Unit = {
    defaultSort()
    sortByDerivedValue()
    sortWithComparator()
    sortCustomType()
  }

}
