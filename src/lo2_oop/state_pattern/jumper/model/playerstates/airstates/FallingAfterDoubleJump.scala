package lo2_oop.state_pattern.jumper.model.playerstates.airstates

import lo2_oop.state_pattern.jumper.model.Player

class FallingAfterDoubleJump(player: Player) extends Falling(player) {

  override def jumpPressed(): Unit = {}
}
