package week6.sorting.inheritance

class Cat(name: String) extends Animal(name) {

  override def sound(): String = {
    "meow"
  }

}
