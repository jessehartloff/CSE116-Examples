package lo2_oop.state_pattern.jumper.tests

import org.scalatest._
import lo2_oop.state_pattern.jumper.physics.objects._
import lo2_oop.state_pattern.jumper.physics.{PhysicsEngine, PhysicsVector, World}

class TestPrimary extends FunSuite {

  val EPSILON: Double = 0.00001

  def equalDouble(x1: Double, x2: Double): Boolean = {
    Math.abs(x1-x2) < EPSILON
  }

  def equalVectors(v1: PhysicsVector, v2: PhysicsVector): Boolean = {
    equalDouble(v1.x, v2.x) && equalDouble(v1.y, v2.y) && equalDouble(v1.z, v2.z)
  }

  def check(wall: StaticObject, obj1: DynamicObject, face: Int): Unit = {
    assert(obj1.collideWithStaticObjectCalled)
    assert(obj1.staticObject == wall)
    assert(wall.collideWithDynamicObjectCalled)
  }

  test("Tests for accurate collision detection between two objects") {

    val world: World = new World(1.0)

    val wall: StaticObject = new StaticObject(new PhysicsVector(-1.0, -1.0, 2.0), new PhysicsVector(2.0, 2.0, 5.0))
    world.staticObjects = wall :: world.staticObjects


    val obj1: DynamicObject = new DynamicObject(new PhysicsVector(0.0, 0.0, 8.0), new PhysicsVector(1.0, 1.0, 1.0))
    obj1.velocity = new PhysicsVector(0.0, 0.0, 0.0)
    world.dynamicObjects = obj1 :: world.dynamicObjects

    val obj2: DynamicObject = new DynamicObject(new PhysicsVector(-10.0, 0.0, 3.0), new PhysicsVector(2.0, 1.0, 1.0))
    obj2.velocity = new PhysicsVector(5.0, 0.0, 1.0)
    world.dynamicObjects = obj2 :: world.dynamicObjects

    val obj3: DynamicObject = new DynamicObject(new PhysicsVector(-10.0, 10.0, 1.0), new PhysicsVector(2.0, 2.0, 2.0))
    obj3.velocity = new PhysicsVector(1.0, -2.0, -0.5)
    world.dynamicObjects = obj3 :: world.dynamicObjects


    PhysicsEngine.updateWorld(world, 1.0)



    equalVectors(obj1.previousLocation, new PhysicsVector(0.0, 0.0, 8.0))
    equalVectors(obj1.velocity, new PhysicsVector(0.0, 0.0, -1.0))
    equalVectors(obj1.location, new PhysicsVector(0.0, 0.0, 7.0))
    assert(!obj1.collideWithStaticObjectCalled)
    assert(!obj1.onGroundCalled)

    equalVectors(obj2.previousLocation, new PhysicsVector(-10.0, 0.0, 3.0))
    equalVectors(obj2.velocity, new PhysicsVector(5.0, 0.0, 0.0))
    equalVectors(obj2.location, new PhysicsVector(-5.0, 0.0, 3.0))
    assert(!obj2.collideWithStaticObjectCalled)
    assert(!obj2.onGroundCalled)

    // Hit the ground
    equalVectors(obj3.previousLocation, new PhysicsVector(-10.0, 10.0, 1.0))
    equalVectors(obj3.velocity, new PhysicsVector(1.0, -2.0, 0.0))
    equalVectors(obj3.location, new PhysicsVector(-9.0, 8.0, 0.0))
    assert(!obj3.collideWithStaticObjectCalled)
    assert(obj3.onGroundCalled)


    PhysicsEngine.updateWorld(world, 1.0)

    equalVectors(obj1.previousLocation, new PhysicsVector(0.0, 0.0, 7.0))
    equalVectors(obj1.velocity, new PhysicsVector(0.0, 0.0, -2.0))
    equalVectors(obj1.location, new PhysicsVector(0.0, 0.0, 5.0))
    check(wall, obj1, Face.top)


    equalVectors(obj2.previousLocation, new PhysicsVector(-5.0, 0.0, 3.0))
    equalVectors(obj2.velocity, new PhysicsVector(5.0, 0.0, -1.0))
    equalVectors(obj2.location, new PhysicsVector(0.0, 0.0, 2.0))
    check(wall, obj2, Face.negativeX)

    assert(wall.face == Face.top || wall.face == Face.negativeX)
    assert(wall.otherObject == obj1 || wall.otherObject == obj2)

  }
}
