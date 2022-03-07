package lo2_oop.oop_physics.polymorphism_memory_diagram

class HealthPotion(val volume: Int) extends GameObject(3.0) {
  val massPerVolume: Double = 7.0
  override def weight(): Double = {
    val bottleWeight: Double = super.weight()
    bottleWeight + this.volume * this.massPerVolume
  }
}
