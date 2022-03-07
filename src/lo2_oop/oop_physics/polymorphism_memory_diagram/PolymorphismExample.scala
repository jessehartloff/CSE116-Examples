package lo2_oop.oop_physics.polymorphism_memory_diagram

object PolymorphismExample {


  def main(args: Array[String]): Unit = {
    val ball: DodgeBall = new DodgeBall(4.0)
    val potion: HealthPotion = new HealthPotion(6)
    val player: Player = new Player()
    player.pickUp(ball)
    player.pickUp(potion)
    val totalWeight: Double = player.totalWeight()
    println(totalWeight)
  }


}
