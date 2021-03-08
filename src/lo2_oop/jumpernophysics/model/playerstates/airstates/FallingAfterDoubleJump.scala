package lo2_oop.jumpernophysics.model.playerstates.airstates

import lo2_oop.jumpernophysics.model.Player

class FallingAfterDoubleJump(player: Player) extends Falling(player) {

  override def jumpPressed(): Unit = {}
}
