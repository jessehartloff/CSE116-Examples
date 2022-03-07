package lo2_oop.state_pattern.hulk.states

import lo2_oop.state_pattern.hulk.{BruceBanner, Car}

abstract class State(banner: BruceBanner) {

  def makeAngry(): Unit

  def calmDown(): Unit

  def useCar(car: Car): Unit

  def fight(): Unit

}
