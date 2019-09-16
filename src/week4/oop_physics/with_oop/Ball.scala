package week4.oop_physics.with_oop

import physics.PhysicsVector


// Use override since DynamicObject already declared variables with these names
class Ball(override var location: PhysicsVector,
           override val dimensions: PhysicsVector,
           override var velocity: PhysicsVector,
           override val mass: Double)
  extends InanimateObject(location, dimensions, velocity) {

  override def use(player: Player): Unit = {
    this.velocity.x = player.orientation.x * player.strength
    this.velocity.y = player.orientation.y * player.strength
    this.velocity.z = player.strength
  }

  override def objectMass(): Double = {
    this.mass
  }


}
