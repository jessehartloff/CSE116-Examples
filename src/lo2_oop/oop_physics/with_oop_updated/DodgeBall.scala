package lo2_oop.oop_physics.with_oop_updated

import archived.physics.PhysicsVector


// Use override since DynamicObject already declared variables with these names
class DodgeBall(location: PhysicsVector,
                velocity: PhysicsVector,
                mass: Double)
  extends GameObject(location) {

  override def use(player: Player): Unit = {
    this.velocity.x = player.orientation.x * player.strength
    this.velocity.y = player.orientation.y * player.strength
  }

  override def objectMass(): Double = {
    this.mass
  }


}
