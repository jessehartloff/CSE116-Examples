package mvc

import scalafx.animation.AnimationTimer
import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.scene.Scene
import scalafx.scene.control.{Button, TextArea, TextField}
import scalafx.scene.layout.{HBox, VBox}

object View extends JFXApp {

  val model: Model = new Model()

  val chatDisplay: TextArea = new TextArea() {
    editable = false
    prefColumnCount = 14
    prefRowCount = 20
    style = "-fx-font: 16 ariel;"
  }

  val inputDisplay: TextField = new TextField {
    style = "-fx-font: 16 ariel;"
  }

  val button: Button = new Button {
    style = "-fx-font: 16 ariel;"
    text = "Send"
    onAction = new Controller(inputDisplay.text, model)
  }

  val horizontalBox: HBox = new HBox() {
    children = List(inputDisplay, button)
  }

  val verticalBox: VBox = new VBox() {
    children = List(chatDisplay, horizontalBox)
  }

  this.stage = new PrimaryStage {
    title = "Chat App"
    scene = new Scene() {
      content = List(verticalBox)
    }

    AnimationTimer(update).start()
  }

  def update(time: Long): Unit = {
    val messages = model.allMessages().reverse
    chatDisplay.text.value = ""
    for (m <- messages) {
      chatDisplay.text.value += m + "\n"
    }

    // Scroll to bottom
    chatDisplay.scrollTop.value = Double.MaxValue
  }

}
