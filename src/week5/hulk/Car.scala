package week5.hulk

class Car {

  var totaled = false

  def drive(overweight: Boolean): Unit = {
    if (this.totaled) {
      println("Can't drive")
    } else if (overweight) {
      println("The suspension was damaged")
    } else {
      println("Driving")

    }
  }

  def smash(): Unit = {
    this.totaled = true
    println("Car was totaled")
  }

}
