package week10.sorting.inheritance

abstract class Animal(val name: String) {

  def sound(): String

  override def toString: String = {
    this.name
  }

}

object Animal {
  def compareAnimals(a1: Animal, a2: Animal): Boolean = {
    a1.name.toLowerCase() < a2.name.toLowerCase()
  }
}