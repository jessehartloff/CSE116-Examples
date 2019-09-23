package week5.hulk.states

class ProfessorHulk(banner: BruceBanner) extends State(banner){

  override def makeAngry(): Unit = {
    println("No problem")
  }

  override def calmDown(): Unit = {
    println("Already calm")
  }

  override def useCar(car: Car): Unit = {
    car.drive(true)
  }

  override def fight(): Unit = {
    println("Smash carefully")
  }

}
