package week4.oop_physics.with_oop

import physics.PhysicsVector


class Player(val location: PhysicsVector,
             val dimensions: PhysicsVector,
             val velocity: PhysicsVector,
             var orientation: PhysicsVector,
             val maxHealth: Int,
             val strength: Int) {

  var health: Int = maxHealth

  def useItem(item: InanimateObject): Unit = {
    item.use(this)
  }

}
