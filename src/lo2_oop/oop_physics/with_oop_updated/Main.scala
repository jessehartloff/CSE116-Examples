package lo2_oop.oop_physics.with_oop_updated

import archived.physics.PhysicsVector

object Main {

  def polymorphismExample(): Unit = {
    val player: Player = new Player(new PhysicsVector(0.0, 0.0),
      new PhysicsVector(1.0, 0.0), 255, 10)

    val potion1: HealthPotion = new HealthPotion(new PhysicsVector(-8.27, -3.58), 6)
    val potion2: HealthPotion = new HealthPotion(new PhysicsVector(-8.046, -2.128), 6)
    val ball: DodgeBall = new DodgeBall(new PhysicsVector(-2.28, 4.88, 5.1689),
      new PhysicsVector(1.0, 1.0, 1.0), 2)

    val gameObjects: List[PhysicsObject] = List(player, potion1, potion2, ball)
    PhysicsEngine.doPhysics(gameObjects)
  }

  def overrideExample(): Unit = {

    val potion1: HealthPotion = new HealthPotion(new PhysicsVector(0, 0, 0),4)
    val potion2: HealthPotion = new HealthPotion(new PhysicsVector(0, 0, 0),4)
    val potion3 = potion1

    println(potion1)
    println(potion2)
    println(potion3)
    println(potion1 == potion2)
    println(potion1 == potion3)
  }

  def main(args: Array[String]): Unit = {
        polymorphismExample()
        overrideExample()
  }


}
