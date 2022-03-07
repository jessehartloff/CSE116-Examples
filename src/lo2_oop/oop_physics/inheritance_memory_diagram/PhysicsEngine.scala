package lo2_oop.oop_physics.inheritance_memory_diagram

object PhysicsEngine {

  def move(obj: PhysicsObject, dx: Double, dy: Double): Unit ={
    obj.x += dx
    obj.y += dy
  }

  def doPhysics(objs: List[PhysicsObject]): Unit = {
    // Physics not implemented. This method would update the location of each object based
    // on the physics of this game
  }

}
