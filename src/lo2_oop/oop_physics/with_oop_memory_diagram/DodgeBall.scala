package lo2_oop.oop_physics.with_oop_memory_diagram


class DodgeBall(var xDB: Double, var yDB: Double, val mass: Double)
  extends GameObject(xDB, yDB) {

  override def objectMass(): Double = {
    this.mass
  }
}
