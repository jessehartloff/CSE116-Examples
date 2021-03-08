package lo2_oop.jumpernophysics.model.playerstates.airstates

import lo2_oop.jumpernophysics.model.Player
import lo2_oop.jumpernophysics.model.playerstates.groundstates.Standing

class Falling(player: Player) extends InAir(player) {

  override def platformCollision(): Unit = {
    player.state = new Standing(player)
  }

}
