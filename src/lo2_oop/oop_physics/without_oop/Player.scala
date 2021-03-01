package lo2_oop.oop_physics.without_oop

import archived.physics.PhysicsVector


class Player(val location: PhysicsVector,
             val dimensions: PhysicsVector,
             val velocity: PhysicsVector,
             val orientation: PhysicsVector,
             val maxHealth: Int,
             val strength: Int) {

  var health: Int = maxHealth

  def useBall(ball: DodgeBall): Unit = {
    ball.use(this)
  }

  def useHealthPotion(potion: HealthPotion): Unit = {
    potion.use(this)
  }
}
