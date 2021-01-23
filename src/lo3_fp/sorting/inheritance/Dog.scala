package lo3_fp.sorting.inheritance

class Dog(name: String) extends Animal(name) {

  override def sound(): String = {
    "woof"
  }

}