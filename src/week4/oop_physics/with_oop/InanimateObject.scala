package week4.oop_physics.with_oop

import physics.PhysicsVector
import physics.objects.DynamicObject


abstract class InanimateObject(location: PhysicsVector, dimensions: PhysicsVector, _velocity: PhysicsVector)
  extends DynamicObject(location, dimensions) {

  this.velocity = _velocity

  def objectMass(): Double

  def use(player: Player): Unit

  def magnitudeOfMomentum(): Unit = {
    val magnitudeOfVelocity = Math.sqrt(
      Math.pow(this.velocity.x, 2.0) +
        Math.pow(this.velocity.y, 2.0) +
        Math.pow(this.velocity.z, 2.0)
    )
    magnitudeOfVelocity * this.objectMass()
  }

}
