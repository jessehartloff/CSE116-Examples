package week6.gui

import javafx.event.EventHandler
import javafx.scene.input.{KeyCode, KeyEvent}
import scalafx.scene.shape.Circle

class KeyEventHandler(player: Circle) extends EventHandler[KeyEvent]{

  val playerSpeed: Int = 10

  override def handle(event: KeyEvent): Unit = {
    keyPressed(event.getCode)
  }

  def keyPressed(keyCode: KeyCode): Unit = {
    keyCode.getName match {
      case "W" => player.translateY.value -= playerSpeed
      case "A" => player.translateX.value -= playerSpeed
      case "S" => player.translateY.value += playerSpeed
      case "D" => player.translateX.value += playerSpeed
      case _ => println(keyCode.getName + " pressed with no action")
    }
  }

}
