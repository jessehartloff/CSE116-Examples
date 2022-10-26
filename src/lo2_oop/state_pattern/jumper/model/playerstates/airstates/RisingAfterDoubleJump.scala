package lo2_oop.state_pattern.jumper.model.playerstates.airstates

import lo2_oop.state_pattern.jumper.model.Player

class RisingAfterDoubleJump(player: Player) extends Rising(player) {

  override def jumpPressed(): Unit = {}

  override def falling(): Unit = {
    player.state = new FallingAfterDoubleJump(player)
  }
}
