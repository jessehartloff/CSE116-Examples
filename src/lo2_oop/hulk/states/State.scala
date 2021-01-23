package lo2_oop.hulk.states

import lo2_oop.hulk.{BruceBanner, Car}

abstract class State(banner: BruceBanner) {

  def makeAngry()

  def calmDown()

  def useCar(car: Car)

  def fight()

}
