package lo2_oop.oop_physics.with_oop_updated

import archived.physics.PhysicsVector


class HealthPotion(location: PhysicsVector, val volume: Int) extends GameObject(location) {

  override def objectMass(): Double = {
    val massPerVolume: Double = 7.0
    volume * massPerVolume
  }

  def use(player: Player): Unit = {
    player.health = (player.health + this.volume).min(player.maxHealth)
  }

  override def toString: String = {
    "location: " + this.location + "; volume: " + volume
  }

  override def equals(obj: Any): Boolean = {
    obj match {
      case hp: HealthPotion => this.volume == hp.volume
      case _ => false
    }
  }

}
