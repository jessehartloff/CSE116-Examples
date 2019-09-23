package week4.oop_physics.with_oop

import physics.PhysicsVector
import physics.objects.DynamicObject


class Player(location: PhysicsVector,
             dimensions: PhysicsVector,
             _velocity: PhysicsVector,
             var orientation: PhysicsVector,
             val maxHealth: Int,
             val strength: Int) extends DynamicObject(location, dimensions) {

  this.velocity = _velocity
  var health: Int = maxHealth

  def useItem(item: InanimateObject): Unit = {
    item.use(this)
  }

}
