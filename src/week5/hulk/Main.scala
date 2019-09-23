package week5.hulk

object Main {

  def main(args: Array[String]): Unit = {
    val bruce: BruceBanner = new BruceBanner()
    val car: Car = new Car()
    bruce.useCar(car)
    bruce.makeAngry()
    bruce.useCar(car)
    bruce.learnControl()
    bruce.fight()
    bruce.makeAngry()
    bruce.calmDown()
  }

}
