package lo2_oop.jumpernophysics.controller

import javafx.event.EventHandler
import javafx.scene.input.KeyEvent
import lo2_oop.jumpernophysics.model.Player

abstract class KeyboardInputs(player: Player) extends EventHandler[KeyEvent] {

  val LEFT: String
  val RIGHT: String
  val JUMP: String

  override def handle(event: KeyEvent): Unit = {
    val keyCode = event.getCode
    event.getEventType.getName match {
      case "KEY_RELEASED" => keyCode.getName match {
        case this.LEFT => player.leftReleased()
        case this.RIGHT => player.rightReleased()
        case this.JUMP => player.jumpReleased()
        case _ =>
      }
      case "KEY_PRESSED" => keyCode.getName match {
        case this.LEFT => player.leftPressed()
        case this.RIGHT => player.rightPressed()
        case this.JUMP => player.jumpPressed()
        case _ =>
      }
      case _ =>
    }
  }
}

class WASDInputs(player: Player) extends KeyboardInputs(player) {
  override val LEFT: String = "A"
  override val RIGHT: String = "D"
  override val JUMP: String = "W"
}


class ArrowInputs(player: Player) extends KeyboardInputs(player) {
  override val LEFT: String = "Left"
  override val RIGHT: String = "Right"
  override val JUMP: String = "Up"
}
