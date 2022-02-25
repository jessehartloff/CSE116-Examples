package lo2_oop.memory.rpg_example

class PartyCharacter() {

  var battlesWon: Int = 0
  var xp: Int = 0

  def winBattle(xp: Int): Unit = {
    this.battlesWon += 1
    this.xp += xp
  }

}
