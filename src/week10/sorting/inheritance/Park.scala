package week10.sorting.inheritance

object Park {

  def animals(): List[Animal] = {
    List(new Cat("Morris"), new Dog("Finn"), new Dog("Snoopy"), new Cat("Garfield"))
  }

  def makeSomeNoise(animals: List[Animal]): List[String] = {
    animals.map(animal => animal.sound())
  }

}
