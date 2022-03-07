package lo2_oop.state_pattern.jumpernophysics.model.playerstates

import lo2_oop.state_pattern.jumpernophysics.model.Player

class GameOver(player: Player) extends PlayerState(player) {

  override def leftPressed(): Unit = {}

  override def rightPressed(): Unit = {}

  override def jumpPressed(): Unit = {}

  override def jumpReleased(): Unit = {}

  override def leftReleased(): Unit = {}

  override def rightReleased(): Unit = {}

  override def platformCollision(): Unit = {}

  override def isAlive: Boolean = {
    false
  }
}
