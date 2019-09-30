package week6.gui

import javafx.event.EventHandler
import javafx.scene.input.MouseEvent
import scalafx.scene.paint.Color
import scalafx.scene.shape.Rectangle

class MouseEventHandler() extends EventHandler[MouseEvent] {

  val rectangleWidth: Double = 60
  val rectangleHeight: Double = 40


  override def handle(event: MouseEvent): Unit = {
    drawRectangle(event.getX, event.getY)
  }

  def drawRectangle(centerX: Double, centerY: Double): Unit = {
    val newRectangle = new Rectangle() {
      width = rectangleWidth
      height = rectangleHeight
      translateX = centerX - rectangleWidth / 2.0
      translateY = centerY - rectangleHeight / 2.0
      fill = Color.Blue
    }
    GUI2D.sceneGraphics.children.add(newRectangle)
    GUI2D.allRectangles = newRectangle :: GUI2D.allRectangles
  }

}
