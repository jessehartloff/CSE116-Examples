package lo2_oop.state_pattern.jumper.model.playerstates.groundstates

import lo2_oop.state_pattern.jumper.model.Player
import lo2_oop.state_pattern.jumper.model.playerstates.airstates.Rising

class Standing(player: Player) extends OnGround(player) {

  override def jumpPressed(): Unit = {
    player.velocity.z = player.standingJumpVelocity
    player.state = new Rising(player)
  }

}
