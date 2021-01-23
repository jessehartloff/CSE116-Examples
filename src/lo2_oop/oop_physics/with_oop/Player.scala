package lo2_oop.oop_physics.with_oop

import archived.physics.PhysicsVector
import archived.physics.objects.DynamicObject


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
