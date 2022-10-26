package lo2_oop.state_pattern.jumper.tests

import org.scalatest._
import lo2_oop.state_pattern.jumper.physics.objects.GameObject
import lo2_oop.state_pattern.jumper.physics.{PhysicsEngine, PhysicsVector}

class TestCollisions extends FunSuite {

  def shouldCollide(obj1: GameObject, obj2: GameObject): Unit = {
    assert(PhysicsEngine.isCollision(obj1, obj2), "\n" + obj1 + "\n" + obj2)
  }

  def shouldNotCollide(obj1: GameObject, obj2: GameObject): Unit = {
    assert(!PhysicsEngine.isCollision(obj1, obj2), "\n~" + obj1 + "\n~" + obj2)
  }

  test("Tests for accurate collision detection between two objects") {

    val obj1: GameObject = new GameObject(new PhysicsVector(4.0, 3.0, 6.0), new PhysicsVector(3.0, 3.0, 3.0))
    val obj2: GameObject = new GameObject(new PhysicsVector(3.0, 2.0, 5.0), new PhysicsVector(1.5, 1.5, 1.5))
    val obj3: GameObject = new GameObject(new PhysicsVector(-3.0, -2.0, -5.0), new PhysicsVector(1.5, 1.5, 1.5))
    val obj4: GameObject = new GameObject(new PhysicsVector(-4.0, -3.0, -6.0), new PhysicsVector(1.5, 1.5, 1.5))
    val obj5: GameObject = new GameObject(new PhysicsVector(-4.0, -3.0, 500.0), new PhysicsVector(1.5, 1.5, 1.5))
    val obj6: GameObject = new GameObject(new PhysicsVector(100.0, 102.0, -105.0), new PhysicsVector(1.5, 1.5, 1.5))

    shouldCollide(obj1, obj2)
    shouldCollide(obj3, obj4)

    shouldNotCollide(obj4, obj5)
    shouldNotCollide(obj1, obj6)
    shouldNotCollide(obj2, obj6)
    shouldNotCollide(obj3, obj6)
    shouldNotCollide(obj4, obj6)
    shouldNotCollide(obj5, obj6)
  }
}
