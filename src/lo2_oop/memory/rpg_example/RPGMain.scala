package lo2_oop.memory.rpg_example

object RPGMain {
  def main(args: Array[String]): Unit = {

    val mobXP: Int = 20
    val bossXP: Int = 100

    val hero: PartyCharacter = new PartyCharacter()
    hero.winBattle(mobXP)

    val party: Party = new Party(hero, new PartyCharacter())
    party.winBattle(bossXP)

    println(hero.xp)
    println(party.character2.xp)
  }
}
