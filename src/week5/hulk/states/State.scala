package week5.hulk.states

import week5.hulk.{BruceBanner, Car}

abstract class State(banner: BruceBanner) {

  def makeAngry()

  def calmDown()

  def useCar(car: Car)

  def fight()

}
