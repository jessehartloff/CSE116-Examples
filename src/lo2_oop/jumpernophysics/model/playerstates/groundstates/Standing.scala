package lo2_oop.jumpernophysics.model.playerstates.groundstates

import lo2_oop.jumpernophysics.model.Player
import lo2_oop.jumpernophysics.model.playerstates.airstates.Rising

class Standing(player: Player) extends OnGround(player) {

  override def jumpPressed(): Unit = {
    player.velocity.z = player.standingJumpVelocity
    player.state = new Rising(player)
  }

}
