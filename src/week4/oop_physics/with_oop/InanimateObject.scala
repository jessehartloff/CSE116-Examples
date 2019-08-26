package week4.oop_physics.with_oop

import week4.oop_physics.{PhysicalObject, PhysicsVector}

abstract class InanimateObject(location: PhysicsVector, velocity: PhysicsVector)
  extends PhysicalObject(location, velocity) {

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
