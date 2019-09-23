package week5.hulk.states

abstract class State(banner: BruceBanner) {

  def makeAngry()

  def calmDown()

  def useCar(car: Car)

  def fight()

}
