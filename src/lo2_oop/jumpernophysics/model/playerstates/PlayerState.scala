package lo2_oop.jumpernophysics.model.playerstates

import lo2_oop.jumpernophysics.model.Player

abstract class PlayerState(player: Player) {

  var timeInState: Double = 0.0

  // Use this line to see state transitions
//  println(this.getClass.getSimpleName)

  def update(dt: Double): Unit = {
    timeInState += dt

    if(player.leftKeyHeld){
      this.leftPressed()
    }
    if(player.rightKeyHeld){
      this.rightPressed()
    }

    if (player.velocity.z < 0.0) {
      player.state.falling()
    }
  }


  // API methods. Most methods do nothing by default. Only override methods that are needed for each state
  def leftPressed(): Unit = {}

  def rightPressed(): Unit = {}

  def jumpPressed(): Unit = {}

  def leftReleased(): Unit = {
    player.stop()
  }

  def rightReleased(): Unit = {
    player.stop()
  }

  def jumpReleased(): Unit = {}

  def platformCollision(): Unit = {}

  def falling(): Unit = {}

  def isAlive: Boolean = {
    true
  }

}
