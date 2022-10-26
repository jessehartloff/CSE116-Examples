package lo2_oop.state_pattern.jumper.model.playerstates.groundstates

import lo2_oop.state_pattern.jumper.model.Player
import lo2_oop.state_pattern.jumper.model.playerstates.airstates.Rising

class Walking(player: Player) extends OnGround(player) {

  override def leftPressed(): Unit = {
    player.walkLeft()
  }

  override def rightPressed(): Unit = {
    player.walkRight()
  }

  override def jumpPressed(): Unit = {
    player.velocity.z = player.walkingJumpVelocity
    player.state = new Rising(player)
  }

  override def leftReleased(): Unit = {
    super.leftReleased()
    player.state = new Standing(player)
  }

  override def rightReleased(): Unit = {
    super.rightReleased()
    player.state = new Standing(player)
  }

}
