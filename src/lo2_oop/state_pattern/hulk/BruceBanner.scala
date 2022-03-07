package lo2_oop.state_pattern.hulk

import lo2_oop.state_pattern.hulk.states._

class BruceBanner {

  var state: State = new DrBanner(this)

  def makeAngry(): Unit = {
    this.state.makeAngry()
  }

  def calmDown(): Unit = {
    this.state.calmDown()
  }

  def useCar(car: Car): Unit = {
    this.state.useCar(car)
  }

  def fight(): Unit = {
    this.state.fight()
  }

  def learnControl():Unit = {
    this.state = new ProfessorHulk(this)
  }

}
