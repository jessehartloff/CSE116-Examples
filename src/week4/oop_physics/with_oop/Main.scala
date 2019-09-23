package week4.oop_physics.with_oop

import physics.{PhysicsEngine, PhysicsVector, World}
import physics.objects.DynamicObject


object Main {

  def polymorphismExample(): Unit = {

    val player: Player = new Player(new PhysicsVector(0.0, 0.0, 0.0),
      new PhysicsVector(1.0, 1.0, 2.0), new PhysicsVector(0.0, 0.0, 0.0),
      new PhysicsVector(1.0, 0.0, 0.0), 10, 255)

    val potion1: HealthPotion = new HealthPotion(new PhysicsVector(-8.27, -3.583, 5.3459),
      new PhysicsVector(1.0, 1.0, 1.0), new PhysicsVector(-9.0, 7.17, -9.441), 6)

    val potion2: HealthPotion = new HealthPotion(new PhysicsVector(-8.046, -2.128, 5.5179),
      new PhysicsVector(1.0, 1.0, 1.0), new PhysicsVector(6.24, -3.18, -4.021), 6)

    val ball1: Ball = new Ball(new PhysicsVector(-2.28, 4.88, 5.1689),
      new PhysicsVector(1.0, 1.0, 1.0), new PhysicsVector(-0.24, 8.59, -6.711), 2)

    val ball2: Ball = new Ball(new PhysicsVector(10.325, -2.14, 0.0),
      new PhysicsVector(1.2, 1.2, 1.2), new PhysicsVector(3.65, -9.0, -7.051), 5)

    val ball3: Ball = new Ball(new PhysicsVector(-6.988, 1.83, 2.5419),
      new PhysicsVector(1.5, 1.5, 1.5), new PhysicsVector(-3.08, 5.4, 7.019), 10)

    val gameObjects: List[DynamicObject] = List(player, potion1, potion2, ball1, ball2, ball3)

    val world: World = new World(15)
    world.dynamicObjects = gameObjects

    PhysicsEngine.updateWorld(world, 0.0167)
  }

  def overrideExample(): Unit = {

    val potion1: HealthPotion = new HealthPotion(new PhysicsVector(0, 0, 0),
      new PhysicsVector(0.7, 0.7, 0.7), new PhysicsVector(0, 0, 0), 4)
    val potion2: HealthPotion = new HealthPotion(new PhysicsVector(0, 0, 0),
      new PhysicsVector(0.7, 0.7, 0.7), new PhysicsVector(0, 0, 0), 4)
    val potion3 = potion1

    println(potion1)
    println(potion2)
    println(potion3)
    println(potion1 == potion2)
    println(potion1 == potion3)
  }

  def main(args: Array[String]): Unit = {
    //    polymorphismExample()
        overrideExample()
  }


}
