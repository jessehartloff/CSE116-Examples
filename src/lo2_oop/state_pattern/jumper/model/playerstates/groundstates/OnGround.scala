package lo2_oop.state_pattern.jumper.model.playerstates.groundstates

import lo2_oop.state_pattern.jumper.model.Player
import lo2_oop.state_pattern.jumper.model.playerstates.PlayerState
import lo2_oop.state_pattern.jumper.model.playerstates.airstates.Falling

abstract class OnGround(player: Player) extends PlayerState(player) {

  override def leftPressed(): Unit = {
    player.walkLeft()
    player.state = new Walking(player)
  }

  override def rightPressed(): Unit = {
    player.walkRight()
    player.state = new Walking(player)
  }

  override def falling(): Unit = {
    player.state = new Falling(player)
  }

}