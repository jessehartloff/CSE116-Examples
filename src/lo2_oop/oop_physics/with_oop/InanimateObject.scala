package lo2_oop.oop_physics.with_oop

import archived.physics.PhysicsVector
import archived.physics.objects.DynamicObject


abstract class InanimateObject(location: PhysicsVector, dimensions: PhysicsVector, _velocity: PhysicsVector)
  extends DynamicObject(location, dimensions) {

  this.velocity = _velocity

  def objectMass(): Double

  def use(player: Player): Unit

  def magnitudeOfMomentum(): Double = {
    val magnitudeOfVelocity = Math.sqrt(
      Math.pow(this.velocity.x, 2.0) +
        Math.pow(this.velocity.y, 2.0) +
        Math.pow(this.velocity.z, 2.0)
    )
    magnitudeOfVelocity * this.objectMass()
  }

}
