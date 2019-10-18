package week8.websocketclient

import io.socket.client.{IO, Socket}
import io.socket.emitter.Emitter
import javafx.application.Platform
import javafx.event.ActionEvent
import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.scene.Scene
import scalafx.scene.control.{Button, Label, TextField}
import scalafx.scene.layout.VBox

class HandleMessagesFromServer() extends Emitter.Listener {
  override def call(objects: Object*): Unit = {
    // Use Platform.runLater when interacting with the GUI
    // This will run your function on the same thread as the GUI allowing access to all GUI elements/variables
    Platform.runLater(() => {
      val message = objects.apply(0).toString
      GUIClient.textOutput.text.value = message
    })

  }
}
class ServerStopped() extends Emitter.Listener {
  override def call(objects: Object*): Unit = {
    Platform.runLater(() => {
      GUIClient.textOutput.text.value = "The server has stopped"
    })
  }
}


object GUIClient extends JFXApp {

  var socket: Socket = IO.socket("http://localhost:8080/")
  socket.on("ACK", new HandleMessagesFromServer)
  socket.on("server_stopped", new ServerStopped)

  socket.connect()

  var chatInput: TextField = new TextField

  val submitButton: Button = new Button{
    text = "submit"
    onAction = (event: ActionEvent) => {
      socket.emit("chat_message", chatInput.text.value)
      chatInput.text.value = ""
    }
  }

  val stopButton: Button = new Button{
    text = "stop server"
    onAction = (event: ActionEvent) => {
      socket.emit("stop_server")
    }
  }

  val lectureQuestionButton: Button = new Button{
    text = "Increment"
    onAction = (event: ActionEvent) => {
      socket.emit("increment")
    }
  }

  val textOutput: Label = new Label

  this.stage = new PrimaryStage {
    title = "CSE Clicker"
    scene = new Scene() {
      content = List(
        new VBox {
          children = List(chatInput, submitButton, stopButton, lectureQuestionButton, textOutput)
        }
      )
    }

  }

}
