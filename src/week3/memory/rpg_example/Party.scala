package week3.memory.rpg_example

class Party(val characterOne: PartyCharacter,
            val characterTwo: PartyCharacter) {

  var battlesWon: Int = 0

  def winBattle(xp: Int): Unit = {
    this.battlesWon += 1
    this.characterOne.battlesWon += 1
    this.characterTwo.battlesWon += 1
    this.characterOne.experiencePoints += xp
    this.characterTwo.experiencePoints += xp
  }

}
