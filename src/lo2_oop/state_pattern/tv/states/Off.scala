package lo2_oop.state_pattern.tv.states

import lo2_oop.state_pattern.tv.TV

class Off(theTV: TV) extends TVState(theTV) {


  override def power(): Unit = {
    this.tv.state = new On(this.tv)
  }

  override def currentVolume(): Int = {
    0
  }

}
