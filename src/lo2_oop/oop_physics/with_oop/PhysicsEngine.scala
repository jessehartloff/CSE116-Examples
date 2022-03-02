package lo2_oop.oop_physics.with_oop

object PhysicsEngine {

  def move(obj: PhysicsObject, dx: Double, dy: Double): Unit ={
    obj.location.x += dx
    obj.location.y += dy
  }

  def doPhysics(physicalObjects: List[PhysicsObject]): Unit = {
    // Physics not implemented. This method would update the location of each object based
    // on the physics of this game
  }

}
