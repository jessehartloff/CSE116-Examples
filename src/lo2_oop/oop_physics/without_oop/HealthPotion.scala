package lo2_oop.oop_physics.without_oop

import archived.physics.PhysicsVector


class HealthPotion(val location: PhysicsVector,
                   val dimensions: PhysicsVector,
                   val velocity: PhysicsVector,
                   val volume: Int) {

  def use(player: Player): Unit = {
    player.health = (player.health + this.volume).min(player.maxHealth)
  }

}
