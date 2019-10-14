package week7.websocketclient

import io.socket.client.{IO, Socket}
import io.socket.emitter.Emitter
import javafx.application.Platform
import javafx.event.ActionEvent
import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.scene.Scene
import scalafx.scene.control.{Button, TextField}
import scalafx.scene.layout.VBox

class HandleMessagesFromServer() extends Emitter.Listener {
  override def call(objects: Object*): Unit = {
    // Use runLater when interacting with the GUI
    Platform.runLater(() => {
      val message = objects.apply(0).toString
      println(message)
    })

  }
}


object Client extends JFXApp {

  var socket: Socket = IO.socket("http://localhost:8080/")
  socket.on("message_type", new HandleMessagesFromServer)

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

  this.stage = new PrimaryStage {
    title = "CSE Clicker"
    scene = new Scene() {
      content = List(
        new VBox {
          children = List(chatInput, submitButton, stopButton)
        }
      )
    }

  }

}
