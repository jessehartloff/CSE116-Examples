package lo2_oop.oop_physics.with_oop_memory_diagram


object InheritanceExample {

  def main(args: Array[String]): Unit = {

    val ball: DodgeBall = new DodgeBall(-2.2, 4.8, 2)

    val potion1: HealthPotion = new HealthPotion(5.0, -3.5, 6)
    val potion2: HealthPotion = potion1

    ball.x += 1.0

    println(ball.objectMass())
    println(potion2.objectMass())
    println(ball.toString())
    println(potion1.toString())
  }
}
