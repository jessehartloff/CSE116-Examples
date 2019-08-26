package week4.oop_physics.with_oop

import week4.oop_physics.PhysicsVector

// Use override since PhysicalObject already declared variables with these names
class Ball(override val location: PhysicsVector,
           override val velocity: PhysicsVector,
           val mass: Double)
  extends InanimateObject(location, velocity) {

  override def use(player: Player): Unit = {
    this.velocity.x = player.orientation.x * player.strength
    this.velocity.y = player.orientation.y * player.strength
    this.velocity.z = player.strength
  }

  override def objectMass(): Double = {
    this.mass
  }


}
