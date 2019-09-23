package week5.hulk.states

class DrBanner(banner: BruceBanner) extends State(banner) {

  override def makeAngry(): Unit = {
    banner.state = new TheHulk(banner)
  }

  override def calmDown(): Unit = {
    println("already calm")
  }

  override def useCar(car: Car): Unit = {
    car.drive(false)
  }

  override def fight(): Unit = {
    println("this won't end well")
  }

}
