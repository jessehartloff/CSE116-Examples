package lo2_oop.oop_physics.with_oop

import lo2_oop.oop_physics.PhysicsVector


class Player(playerLocation: PhysicsVector,
             var orientation: PhysicsVector,
             val maxHealth: Int,
             val strength: Int) extends GameObject(playerLocation) {

  var health: Int = maxHealth

  def useItem(item: GameObject): Unit = {
    item.use(this)
  }

  override def objectMass(): Double = {
    this.strength * 20.0
  }

  override def use(player: Player): Unit = {
    player.health = (player.health - this.strength).max(0)
  }
}
