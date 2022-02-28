package lo2_oop.oop_physics.with_oop

import lo2_oop.oop_physics.PhysicsVector


class Player(playerLocation: PhysicsVector,
             var orientation: PhysicsVector,
             val maxHealth: Int,
             val strength: Int) extends PhysicsObject(playerLocation) {

  var health: Int = maxHealth

  def useItem(item: GameObject): Unit = {
    item.use(this)
  }

}
