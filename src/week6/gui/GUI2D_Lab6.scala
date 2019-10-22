package week6.gui

import javafx.scene.input.MouseEvent
import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.scene.paint.Color
import scalafx.scene.shape.Rectangle
import scalafx.scene.{Group, Scene}

object GUI2D_Lab6 extends JFXApp {

  val windowWidth: Double = 800
  val windowHeight: Double = 600

  val rectangleWidth: Double = 60
  val rectangleHeight: Double = 40

  var sceneGraphics: Group = new Group {}

  def addRectangle(centerX: Double, centerY: Double): Unit = {
    val newRectangle = new Rectangle() {
      width = rectangleWidth
      height = rectangleHeight
      translateX = centerX - rectangleWidth / 2.0
      translateY = centerY - rectangleHeight / 2.0
      fill = Color.Blue
    }
    sceneGraphics.children.add(newRectangle)
  }

  this.stage = new PrimaryStage {
    this.title = "Remembering Rectangles"
    scene = new Scene(windowWidth, windowHeight) {
      content = List(sceneGraphics)
    }
    addEventHandler(MouseEvent.MOUSE_CLICKED, (event: MouseEvent) => {addRectangle(event.getX, event.getY)})
  }

}