package lo2_oop.jumpernophysics.model

import lo2_oop.jumpernophysics.model.game_objects.{JumperObject, Platform, Wall}
import lo2_oop.jumpernophysics.model.playerstates.GameOver
import lo2_oop.jumpernophysics.physics.{PhysicsEngine, PhysicsVector, World}

class Game {

  val world = new World(10)

  val gridWidth: Double = 15
  val gridHeight: Double = 20

  val playerSize: Double = 0.3

  // Initial kill line is just below the ground. With proper ground physics, no player will hit this line
  var killLine: Double = -0.0001

  val minPlatformWidth = 1.0
  val maxPlatformWidth = 6.0
  val maxPlatformGaps = 8.0
  val probabilityOfNoPlatforms = 0.2
  val gapProbability = 0.8
  val platformThickness = 0.1

  var staticObjects: List[JumperObject] = List()

  var lastLevelGenerated = 0

  // Track consecutive skipped levels to reduce the probability of impossible jumps
  var skipped = 0
  var maxConsecutiveSkips = 2

  // Generates all the platforms up to the given level when called. This allows platforms to be generated
  // off screen as a player climbs higher
  def generateUntilLevel(levelStop: Int): Unit = {

    val leftWall = new Wall(new PhysicsVector(0.0, -1.0, lastLevelGenerated), new PhysicsVector(platformThickness, 2.0, levelStop))
    val rightWall = new Wall(new PhysicsVector(gridWidth - platformThickness, -1.0, lastLevelGenerated), new PhysicsVector(platformThickness, 2.0, levelStop))
    staticObjects = leftWall :: staticObjects
    staticObjects = rightWall :: staticObjects

    for (level <- lastLevelGenerated + 1 to levelStop) {
      var currentRow = if (skipped < maxConsecutiveSkips && Math.random() < probabilityOfNoPlatforms) {
        skipped += 1
        gridWidth
      } else {
        skipped = 0
        1.0
      }
      while (currentRow < gridWidth - 3) {
        if (Math.random() < gapProbability) {
          currentRow += Math.random() * maxPlatformGaps
        }
        val platformWidth = minPlatformWidth.max(Math.random() * maxPlatformWidth)

        val newPlatform = new Platform(new PhysicsVector(currentRow, -1.0, level - platformThickness), new PhysicsVector((gridWidth - 1).min(currentRow + platformWidth), 2.0, platformThickness))
        currentRow += platformWidth + 1.0
        staticObjects = newPlatform :: staticObjects
        world.staticObjects = staticObjects
      }
    }
    lastLevelGenerated = levelStop
  }

  generateUntilLevel(gridHeight.toInt - 5)

  val player1 = new Player(
    new PhysicsVector(gridWidth / 3.0, 0, 0.0),
    new PhysicsVector(playerSize, playerSize, playerSize)
  )

  val player2 = new Player(
    new PhysicsVector(gridWidth * 2.0 / 3.0, 0, 0.0),
    new PhysicsVector(playerSize, playerSize, playerSize)
  )

  world.dynamicObjects = List(player1, player2)

  def updateWorldAsPlayerRises(player: Player): Unit = {
    if (player.location.z > (killLine + gridHeight / 2.0)) {
      killLine = player.location.z - gridHeight / 2.0
    }
    if (player.location.z > lastLevelGenerated - gridHeight) {
      generateUntilLevel(lastLevelGenerated + gridHeight.toInt)
    }
  }

  def checkIfPlayerFell(player: Player, name: String): Unit = {
    if (player.location.z < killLine && player.isAlive) {
      player.state = new GameOver(player1)

      // Could add game states and transition to an EndGame state. For now, just print that the player fell
      println(name + " fell")
    }
  }

  def update(deltaTime: Double): Unit = {
    PhysicsEngine.updateWorld(this.world, deltaTime)
    player1.update(deltaTime)
    player2.update(deltaTime)

    updateWorldAsPlayerRises(player1)
    updateWorldAsPlayerRises(player2)

    checkIfPlayerFell(player1, "Player 1")
    checkIfPlayerFell(player2, "Player 2")
  }

}
