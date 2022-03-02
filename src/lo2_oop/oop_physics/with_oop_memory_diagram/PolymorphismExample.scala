package lo2_oop.oop_physics.with_oop_memory_diagram


object PolymorphismExample {

  def main(args: Array[String]): Unit = {

    val potion1: HealthPotion = new HealthPotion(5.0, -3.5, 6)
    val potion2: HealthPotion = new HealthPotion(-8.0, 2.0, 6)
    val potion3: HealthPotion = potion1

    val ball: DodgeBall = new DodgeBall(-2.2, 4.8, 2)

    potion1.objectMass()

    println(potion1)
    println(potion2)
    println(potion1 == potion2)

  }


}
