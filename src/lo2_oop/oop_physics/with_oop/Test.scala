package lo2_oop.oop_physics.with_oop

import lo2_oop.oop_physics.PhysicsVector

class Test(location: PhysicsVector) extends PhysicsObject(new PhysicsVector()) {

  override def toString: String = {
    location.x.toString + super.location.x.toString
  }
//  override def toString: String = super.toString

}
