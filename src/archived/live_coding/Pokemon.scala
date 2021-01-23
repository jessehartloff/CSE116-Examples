package archived.live_coding

abstract class Pokemon(val name: String) {

  val pokemonType: String

  var current_hp: Int = 100

  def takeDamage(deltaHP: Int): Unit = {
    this.current_hp -= deltaHP
  }
}
