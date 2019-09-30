package week6.gui

import javafx.scene.input.{KeyEvent, MouseEvent}
import scalafx.animation.AnimationTimer
import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.scene.paint.Color
import scalafx.scene.shape.{Circle, Shape}
import scalafx.scene.{Group, Scene}

object GUI2D extends JFXApp {

  val windowWidth: Double = 800
  val windowHeight: Double = 600

  val playerCircleRadius:Double = 20

  var allRectangles: List[Shape] = List()

  var sceneGraphics: Group = new Group {}

  val player: Circle = new Circle {
    centerX = Math.random() * windowWidth
    centerY = Math.random() * windowHeight
    radius = playerCircleRadius
    fill = Color.Green
  }

  sceneGraphics.children.add(player)

  this.stage = new PrimaryStage {
    this.title = "2D Graphics"
    scene = new Scene(windowWidth, windowHeight) {
      content = List(sceneGraphics)

      // add an EventHandler[KeyEvent] to control player movement
      addEventHandler(KeyEvent.KEY_PRESSED, new KeyEventHandler(player))

      // add an EventHandler[MouseEvent] to draw a rectangle when the player clicks the screen
      addEventHandler(MouseEvent.MOUSE_CLICKED, new MouseEventHandler())
    }

    // define a function for the action timer (Could also use a method)
    // Rotate all rectangles (relies on frame rate. lag will slow rotation)
    val update: Long => Unit = (time: Long) => {
      for (shape <- allRectangles) {
        shape.rotate.value += 0.5
      }
    }

    // Start Animations. Calls update 60 times per second (takes update as an argument)
    AnimationTimer(update).start()
  }

}
