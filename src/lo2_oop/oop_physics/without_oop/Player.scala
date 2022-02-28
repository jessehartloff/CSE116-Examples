package lo2_oop.oop_physics.without_oop

import lo2_oop.oop_physics.PhysicsVector


class Player(val playerLocation: PhysicsVector,
             var orientation: PhysicsVector,
             val maxHealth: Int,
             val strength: Int) {

  var health: Int = maxHealth

  def useDodgeBall(ball: DodgeBall): Unit = {
    ball.use(this)
  }

  def useHealthPotion(potion: HealthPotion): Unit = {
    potion.use(this)
  }
}
