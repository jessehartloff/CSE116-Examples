package week4.oop_physics.without_oop

import week4.oop_physics.PhysicsVector

class Player(val location: PhysicsVector,
             val velocity: PhysicsVector,
             val orientation: PhysicsVector,
             val maxHealth: Int,
             val strength: Int) {

  var health: Int = maxHealth

  def useBall(ball: Ball): Unit = {
    ball.use(this)
  }

  def useHealthPotion(potion: HealthPotion): Unit = {
    potion.use(this)
  }
}
