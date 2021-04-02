package lo2_oop.jumpernophysics.view

import lo2_oop.jumpernophysics.controller.{ArrowInputs, WASDInputs}
import javafx.scene.input.KeyEvent
import lo2_oop.jumpernophysics.model.Game
import lo2_oop.jumpernophysics.model.game_objects.JumperObject
import lo2_oop.jumpernophysics.physics.objects.GameObject
import scalafx.animation.AnimationTimer
import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.scene.paint.Color
import scalafx.scene.shape.{Rectangle, Shape}
import scalafx.scene.{Group, Scene}

object JumperApp extends JFXApp {

  var lastUpdateTime: Long = System.nanoTime()

  val game = new Game()

  val scaleFactor: Double = 30.0

  val windowWidth: Double = game.gridWidth * scaleFactor
  val windowHeight: Double = game.gridHeight * scaleFactor

  var platformSprites: Map[Int, Shape] = Map[Int, Shape]()

  var sceneGraphics: Group = new Group {}

  val player1Sprite: Shape = getSprite(game.player1, Color.Blue)
  val player2Sprite: Shape = getSprite(game.player2, Color.Red)

  sceneGraphics.children.add(player1Sprite)
  sceneGraphics.children.add(player2Sprite)


  def convertY(gameY: Double, height: Double): Double = {
    (game.gridHeight - (gameY - game.killLine) - height) * scaleFactor
  }


  def getSprite(gameObject: GameObject, color: Color): Shape = {
    new Rectangle {
      width = gameObject.dimensions.x * scaleFactor
      height = gameObject.dimensions.z * scaleFactor
      translateX = gameObject.location.x * scaleFactor
      translateY = convertY(gameObject.location.z, gameObject.dimensions.z)
      fill = color
    }
  }


  this.stage = new PrimaryStage {
    this.title = "Jumper"
    scene = new Scene(windowWidth, windowHeight) {
      content = List(sceneGraphics)
      addEventHandler(KeyEvent.ANY, new WASDInputs(game.player1))
      addEventHandler(KeyEvent.ANY, new ArrowInputs(game.player2))
    }

    val update: Long => Unit = (time: Long) => {
      val dt: Double = (time - lastUpdateTime) / 1000000000.0
      lastUpdateTime = time
      game.update(dt)

      player1Sprite.translateX.value = game.player1.location.x * scaleFactor
      player1Sprite.translateY.value = convertY(game.player1.location.z, game.player1.dimensions.z)

      player2Sprite.translateX.value = game.player2.location.x * scaleFactor
      player2Sprite.translateY.value = convertY(game.player2.location.z, game.player2.dimensions.z)

      game.staticObjects.foreach((staticObject: JumperObject) => {
        if (platformSprites.contains(staticObject.objectID)) {
          platformSprites(staticObject.objectID).translateX.value = staticObject.location.x * scaleFactor
          platformSprites(staticObject.objectID).translateY.value = convertY(staticObject.location.z, staticObject.dimensions.z)
        } else {
          val sprite: Shape = getSprite(staticObject, Color.Black)
          sceneGraphics.children.add(sprite)
          platformSprites += (staticObject.objectID -> sprite)
        }
      })
    }

    // Start Animations. Calls update 60 times per second (takes update as an argument)
    AnimationTimer(update).start()
  }

}
