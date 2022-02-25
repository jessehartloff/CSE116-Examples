package lo2_oop.memory.rpg_example

class Party(val character1: PartyCharacter,
            val character2: PartyCharacter) {

  var battlesWon: Int = 0

  def winBattle(xp: Int): Unit = {
    this.battlesWon += 1
    this.character1.winBattle(xp)
    this.character2.winBattle(xp)
  }

}
