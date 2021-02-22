package lo2_oop.objects

class Player(var xLocation: Double, var yLocation: Double, val maxHitPoints: Int) {

  var hp: Int = this.maxHitPoints
  val damageDealt: Int = 4

  def takeDamage(damage: Int): Unit = {
    this.hp -= damage
  }

  def attack(otherPlayer: Player): Unit ={
    otherPlayer.takeDamage(this.damageDealt)
  }

  def conscious(): Boolean = {
    this.hp > 0
  }

  def move(dx: Double, dy: Double): Unit = {
    this.xLocation += dx
    this.yLocation += dy
  }

}
