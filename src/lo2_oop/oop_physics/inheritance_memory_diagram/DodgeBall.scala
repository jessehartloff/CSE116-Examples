package lo2_oop.oop_physics.inheritance_memory_diagram

class DodgeBall(var xDB: Double, var yDB: Double, val mass: Double)
  extends GameObject(xDB, yDB) {

  override def objectMass(): Double = {
    this.mass
  }

}
