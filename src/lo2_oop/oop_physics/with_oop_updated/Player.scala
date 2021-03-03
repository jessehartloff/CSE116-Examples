package lo2_oop.oop_physics.with_oop_updated

import archived.physics.PhysicsVector

class Player(location: PhysicsVector,
             var orientation: PhysicsVector,
             val maxHealth: Int,
             val strength: Int) extends PhysicsObject(location) {

  var health: Int = maxHealth

  def useItem(item: GameObject): Unit = {
    item.use(this)
  }

}
