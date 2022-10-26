package lo2_oop.state_pattern.jumper.model.playerstates

import lo2_oop.state_pattern.jumper.model.Player

class GameOver(player: Player) extends PlayerState(player) {

  override def update(dt: Double): Unit = {}

  override def leftPressed(): Unit = {}

  override def rightPressed(): Unit = {}

  override def jumpPressed(): Unit = {}

  override def jumpReleased(): Unit = {}

  override def leftReleased(): Unit = {}

  override def rightReleased(): Unit = {}

  override def isAlive: Boolean = {
    false
  }
}
