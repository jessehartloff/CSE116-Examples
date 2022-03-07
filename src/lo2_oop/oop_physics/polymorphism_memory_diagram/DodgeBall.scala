package lo2_oop.oop_physics.polymorphism_memory_diagram

class DodgeBall(val size: Double) extends GameObject(0.0) {
  override def weight(): Double = {size * 5.0}
}
