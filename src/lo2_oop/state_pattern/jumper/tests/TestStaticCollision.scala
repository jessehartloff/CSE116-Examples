package lo2_oop.state_pattern.jumper.tests

import org.scalatest._
import lo2_oop.state_pattern.jumper.physics.objects._
import lo2_oop.state_pattern.jumper.physics.{PhysicsEngine, PhysicsVector}

class TestStaticCollision extends FunSuite {

  def check(wall: StaticObject, obj1: DynamicObject, face: Int): Unit = {
    PhysicsEngine.checkStaticCollision(wall, obj1)

    assert(obj1.collideWithStaticObjectCalled)
    assert(obj1.staticObject == wall)
    assert(wall.collideWithDynamicObjectCalled)
    assert(wall.otherObject == obj1)
    assert(wall.face == face)
  }


  test("Tests for accurate collision detection between two objects") {

    val wall: StaticObject = new StaticObject(new PhysicsVector(-1.0, -1.0, 2.0), new PhysicsVector(2.0, 2.0, 5.0))

    val obj1: DynamicObject = new DynamicObject(new PhysicsVector(0.0, 0.0, 7.5), new PhysicsVector(1.0, 1.0, 1.0))
    obj1.velocity = new PhysicsVector(0.0, 0.0, 0.0)

    PhysicsEngine.updateObject(obj1, 0.01, 10.0)
    PhysicsEngine.checkStaticCollision(wall, obj1)
    assert(!obj1.collideWithStaticObjectCalled)
    assert(!wall.collideWithDynamicObjectCalled)

    println(obj1)

    PhysicsEngine.updateObject(obj1, 0.3, 10.0)

    check(wall, obj1, Face.top)


    val obj2: DynamicObject = new DynamicObject(new PhysicsVector(-5.0, 0.0, 3.0), new PhysicsVector(5.0, 1.0, 1.0))
    obj2.previousLocation = new PhysicsVector(-10.0, 0.0, 3.0)

    check(wall, obj2, Face.negativeX)


    val obj3: DynamicObject = new DynamicObject(new PhysicsVector(-5.0, 0.0, 3.0), new PhysicsVector(5.0, 1.0, 1.0))
    obj3.previousLocation = new PhysicsVector(-4.0, 0.0, 3.0)

    check(wall, obj3, Face.internal)


  }
}
