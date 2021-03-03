package lo2_oop.oop_physics.without_oop

import archived.physics.PhysicsVector

class DodgeBall(val location: PhysicsVector,
                val dimensions: PhysicsVector,
                val velocity: PhysicsVector,
                val mass: Double) {

  def use(player: Player): Unit = {
    this.velocity.x = player.orientation.x * player.strength
    this.velocity.y = player.orientation.y * player.strength
    this.velocity.z = player.strength
  }

}
