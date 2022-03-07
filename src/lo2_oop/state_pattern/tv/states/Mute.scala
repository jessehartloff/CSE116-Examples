package lo2_oop.state_pattern.tv.states

import lo2_oop.state_pattern.tv.TV

class Mute(theTV: TV) extends TVState(theTV) {

  override def volumeUp(): Unit = {
    this.tv.state = new On(this.tv)
  }

  override def volumeDown(): Unit = {
    this.tv.state = new On(this.tv)
  }

  override def mute(): Unit = {
    this.tv.state = new On(this.tv)
  }

  override def power(): Unit = {
    this.tv.state = new Off(this.tv)
  }

  override def currentVolume(): Int = {
    0
  }


}
