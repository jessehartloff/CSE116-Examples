package week4.oop_physics.with_oop

import physics.PhysicsVector


class HealthPotion(location: PhysicsVector,
                   dimensions: PhysicsVector,
                   velocity: PhysicsVector,
                   val volume: Int)
  extends InanimateObject(location, dimensions, velocity) {


  override def objectMass(): Double = {
    val massPerVolume: Double = 7.0
    volume * massPerVolume
  }

  def use(player: Player): Unit = {
    player.health = (player.health + this.volume).min(player.maxHealth)
  }

  override def toString: String = {
    "location: " + this.location + "; velocity: " + this.velocity + "; volume: " + volume
  }

  override def equals(obj: Any): Boolean = {
    obj match {
      case hp: HealthPotion => this.volume == hp.volume
      case _ => false
    }
  }

}
