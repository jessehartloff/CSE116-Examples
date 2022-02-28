package lo2_oop.oop_physics.with_oop

import lo2_oop.oop_physics.PhysicsVector


class DodgeBall(dbLocation: PhysicsVector,
                var velocity: PhysicsVector,
                val mass: Double)
  extends GameObject(dbLocation) {

  override def objectMass(): Double = {
    this.mass
  }

  override def use(player: Player): Unit = {
    this.velocity.x = player.orientation.x * player.strength
    this.velocity.y = player.orientation.y * player.strength
  }

}
