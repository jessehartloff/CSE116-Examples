package lo2_oop.state_pattern.jumper.tests

import org.scalatest._
import lo2_oop.state_pattern.jumper.physics.objects.DynamicObject
import lo2_oop.state_pattern.jumper.physics.{PhysicsEngine, PhysicsVector}

class TestObjectUpdate extends FunSuite {

  val EPSILON: Double = 0.00001

  def equalDouble(x1: Double, x2: Double): Boolean = {
    Math.abs(x1-x2) < EPSILON
  }

  def equalVectors(v1: PhysicsVector, v2: PhysicsVector): Boolean = {
    equalDouble(v1.x, v2.x) && equalDouble(v1.y, v2.y) && equalDouble(v1.z, v2.z)
  }

  test("Tests for updating dynamic objects") {

    // Object gravity
    val obj1: DynamicObject = new DynamicObject(new PhysicsVector(4.0, 3.0, 6.0), new PhysicsVector(3.0, 3.0, 3.0))
    obj1.velocity = new PhysicsVector(1.0, 1.0, 1.0)

    PhysicsEngine.updateObject(obj1, 1.0, 2.0)

    assert(equalVectors(obj1.previousLocation, new PhysicsVector(4.0, 3.0, 6.0)))
    assert(equalVectors(obj1.location, new PhysicsVector(5.0, 4.0, 5.0)))
    assert(equalVectors(obj1.velocity, new PhysicsVector(1.0, 1.0, -1.0)))
    assert(!obj1.onGroundCalled)

    // Hitting the ground
    PhysicsEngine.updateObject(obj1, 1.0, 10.0)

    assert(equalVectors(obj1.previousLocation, new PhysicsVector(5.0, 4.0, 5.0)))
    assert(equalVectors(obj1.location, new PhysicsVector(6.0, 5.0, 0.0)))
    assert(equalVectors(obj1.velocity, new PhysicsVector(1.0, 1.0, 0.0)))
    assert(obj1.onGroundCalled)
  }
}
