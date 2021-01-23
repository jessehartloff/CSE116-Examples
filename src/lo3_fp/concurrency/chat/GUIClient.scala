package lo3_fp.concurrency.chat

import io.socket.client.{IO, Socket}
import io.socket.emitter.Emitter
import javafx.application.Platform
import javafx.event.ActionEvent
import play.api.libs.json.{JsValue, Json}
import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.scene.Scene
import scalafx.scene.control.{Button, TextArea, TextField}
import scalafx.scene.layout.VBox

class ChatHistory() extends Emitter.Listener {
  override def call(objects: Object*): Unit = {
    // Use Platform.runLater when interacting with the GUI
    // This will run your function on the same thread as the GUI allowing access to all GUI elements/variables
    Platform.runLater(() => {
      val message = objects.apply(0).toString
      val history = Json.parse(message).as[List[JsValue]]
      GUIClient.textOutput.text.value = ""
      for (chat: JsValue <- history) {
        val username = (chat \ "username").as[String]
        val text = (chat \ "message").as[String]
        GUIClient.textOutput.text.value += username + ": " + text + "\n"
      }
    })
  }
}


class UpdateChat() extends Emitter.Listener {
  override def call(objects: Object*): Unit = {
    Platform.runLater(() => {
      val message = objects.apply(0).toString
      val newMessage = Json.parse(message)
      val username = (newMessage \ "username").as[String]
      val text = (newMessage \ "message").as[String]
      GUIClient.textOutput.text.value = username + ": " + text + "\n" + GUIClient.textOutput.text.value
    })
  }
}


object GUIClient extends JFXApp {

  val windowWidth: Double = 545
  val windowHeight: Double = 390

//  var socket: Socket = IO.socket("https://chat.cse-software.com")
  var socket: Socket = IO.socket("http://localhost:8080/")
  socket.on("chat_history", new ChatHistory)
  socket.on("new_message", new UpdateChat)
  socket.connect()

  var chatInput: TextField = new TextField

  val submitButton: Button = new Button {
    text = "submit"
    onAction = (event: ActionEvent) => {
      socket.emit("chat_message", chatInput.text.value)
      chatInput.text.value = ""
    }
  }

  val textOutput: TextArea = new TextArea {
    editable = false
    prefRowCount = 20
    prefColumnCount = 40
  }

  val chatElements = List(chatInput, submitButton, textOutput)

  val contentBox: VBox = new VBox {
    children = List()
  }

  var usernameInput: TextField = new TextField

  val usernameButton: Button = new Button {
    text = "submit username"
    onAction = (event: ActionEvent) => {
      socket.emit("register", usernameInput.text.value)
      usernameInput.text.value = ""
      contentBox.children = chatElements
    }
  }

  val usernameElements = List(usernameInput, usernameButton)

  contentBox.children = usernameElements

  this.stage = new PrimaryStage {
    title = "CSE Clicker"
    scene = new Scene(windowWidth, windowHeight) {
      content = List(contentBox)
    }

  }

}
