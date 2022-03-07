package lo2_oop.oop_physics.inheritance_memory_diagram


abstract class GameObject(var xObj: Double, var yObj: Double)
  extends PhysicsObject(xObj, yObj) {

  def objectMass(): Double

  override def toString: String = {
    "(" + this.x + ", " + this.y + "); mass: " + this.objectMass()
  }
}
