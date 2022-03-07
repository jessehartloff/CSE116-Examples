package lo2_oop.state_pattern.tv.states

import lo2_oop.state_pattern.tv.TV

class On(theTV: TV) extends TVState(theTV) {

  override def volumeUp(): Unit = {
    this.tv.volume += 1
    this.tv.volume = Math.min(this.tv.volume, this.tv.maxVolume)
  }

  override def volumeDown(): Unit = {
    this.tv.volume -= 1
    this.tv.volume = Math.max(this.tv.volume, 0)
  }

  override def mute(): Unit = {
    this.tv.state = new Mute(this.tv)
  }

  override def power(): Unit = {
    this.tv.state = new Off(this.tv)
  }

}
