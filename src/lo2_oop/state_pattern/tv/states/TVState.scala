package lo2_oop.state_pattern.tv.states

import lo2_oop.state_pattern.tv.TV

class TVState(val tv: TV) {

  def volumeUp(): Unit = {}

  def volumeDown(): Unit = {}

  def mute(): Unit = {}

  def power(): Unit = {}

  def currentVolume(): Int = {
    this.tv.volume
  }

}
