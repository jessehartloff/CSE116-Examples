package lo2_oop.oop_physics.inheritance_memory_diagram


class HealthPotion(var xPotion: Double, var yPotion: Double, val volume: Int)
  extends GameObject(xPotion, yPotion) {

  override def objectMass(): Double = {
    val massPerVolume: Double = 7.0
    this.volume * massPerVolume
  }

  override def toString: String = {
    super.toString() + "; volume: " + this.volume
  }
}
