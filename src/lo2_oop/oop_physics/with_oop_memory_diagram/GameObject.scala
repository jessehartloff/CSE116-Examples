package lo2_oop.oop_physics.with_oop_memory_diagram


abstract class GameObject(var xObj: Double, var yObj: Double)
  extends PhysicsObject(xObj, yObj) {

  def objectMass(): Double

//  def distance(obj: GameObject): Double = {
//    val distance = Math.sqrt(Math.pow(this.x - obj.x, 2.0) + Math.pow(this.y - obj.y, 2.0))
//    distance
//  }

  override def toString: String = {
    "(" + this.x + ", " + this.y + "); mass: " + this.objectMass()
  }
}
