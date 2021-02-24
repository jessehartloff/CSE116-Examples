package lo2_oop.testing

import lo2_oop.objects.Player
import org.scalatest._

class TestPlayer extends FunSuite {

  val epsilon: Double = 0.0001

  def compareDoubles(d1: Double, d2: Double): Boolean = {
    Math.abs(d1 - d2) < epsilon
  }


  def printPlayerLocation(player: Player): Unit = {
    println("The player is at location (" + player.xLocation + ", " + player.yLocation + ")")
  }

  def checkPlayerLocation(player: Player, expectedX: Double, expectedY: Double): Unit = {
    assert(compareDoubles(player.xLocation, expectedX))
    assert(compareDoubles(player.yLocation, expectedY))
  }

  test("Test the Player class") {

    // create player 1 who starts at the origin of the game world with 10 hp
    val player1: Player = new Player(0.0, 0.0, 10)

    // create player 2 who starts at location (7.0, -4.0) with 10 hp
    val player2: Player = new Player(7.0, -4.0, 10)

    printPlayerLocation(player1)
    printPlayerLocation(player2)

    checkPlayerLocation(player1, 0.0, 0.0)
    checkPlayerLocation(player2, 7.0, -4.0)

    player2.move(-6.5, 3.4)

    checkPlayerLocation(player2, 0.5, -0.6)

    player2.attack(player1)
    player2.attack(player1)

    assert(player1.hp == 2)
    assert(player1.conscious())

    player2.attack(player1)

    assert(!player1.conscious())

  }


  test("Playing with references") {

    // create player 1 who starts at the origin of the game world with 10 hp
    val player1: Player = new Player(0.0, 0.0, 10)

    // assign player2 the value of player1
    // Since only references to objects are stored in variable, player2 is
    // assigned the reference stored in player1
    // The result: player1 and player2 refer to the same object on the heap. There is only 1 player
    val player2: Player = player1

    checkPlayerLocation(player1, 0.0, 0.0)
    checkPlayerLocation(player2, 0.0, 0.0)

    player2.move(3.0, 4.0)

    // We only move player2. Since player1 and player2 refer to the same player, both appear to move
    checkPlayerLocation(player1, 3.0, 4.0)
    checkPlayerLocation(player2, 3.0, 4.0)

    player2.attack(player1)
    player2.attack(player1)

    assert(player1.hp == 2)
    assert(player1.conscious())
    assert(player2.hp == 2)
    assert(player2.conscious())

    player2.attack(player1)

    assert(!player1.conscious())
    assert(!player2.conscious())

  }


}
