package lo2_oop.oop_physics.with_oop

import lo2_oop.oop_physics.PhysicsVector


abstract class GameObject(objectLocation: PhysicsVector) extends PhysicsObject(objectLocation) {

  def objectMass(): Double

  def use(player: Player): Unit

  def closeToPlayer(player: Player): Boolean = {
    val distanceToPlayer = Math.sqrt(
      Math.pow(this.location.x - player.location.x, 2.0) +
        Math.pow(this.location.y - player.location.y, 2.0)
    )
    val threshold: Double = 0.5
    distanceToPlayer < threshold
  }

}
