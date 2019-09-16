package week4.oop_physics.without_oop

import physics.PhysicsVector


class HealthPotion(val location: PhysicsVector,
                   val dimensions: PhysicsVector,
                   val velocity: PhysicsVector,
                   val volume: Int) {

  def use(player: Player): Unit = {
    player.health = (player.health + this.volume).min(player.maxHealth)
  }

}
