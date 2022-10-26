package lo2_oop.state_pattern.tv

import lo2_oop.state_pattern.tv.states._

class TV {

//  API: Volume up, volume down, mute, power, currentVolume

  var volume: Int = 5
  val maxVolume: Int = 10

  var state: TVState = new Off(this)

  def volumeUp(): Unit = {
    this.state.volumeUp()
  }

  def volumeDown(): Unit = {
    this.state.volumeDown()
  }

  def mute(): Unit ={
    this.state.mute()
  }

  def power(): Unit = {
    this.state.power()
  }

  def currentVolume(): Int ={
    this.state.currentVolume()
  }

}
