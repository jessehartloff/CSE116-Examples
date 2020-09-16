package week3.memory.rpg_example

object RPGMain {

  def winBattle(character: PartyCharacter, xp: Int): Unit = {
    character.battlesWon += 1
    character.experiencePoints += xp
  }

  def main(args: Array[String]): Unit = {

    val mobXP: Int = 20
    val bossXP: Int = 100

    val hero: PartyCharacter = new PartyCharacter()
    winBattle(hero, mobXP)

    val party: Party = new Party(hero, new PartyCharacter())
    party.winBattle(bossXP)

    winBattle(party.characterOne, mobXP)
    winBattle(party.characterTwo, mobXP)
  }

}
