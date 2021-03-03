package lo2_oop.oop_physics.with_oop_updated

import archived.physics.PhysicsVector
import archived.physics.objects.DynamicObject

abstract class GameObject(location: PhysicsVector) extends PhysicsObject(location) {

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
