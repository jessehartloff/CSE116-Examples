package week8.chat

import com.corundumstudio.socketio.listener.{DataListener, DisconnectListener}
import com.corundumstudio.socketio.{AckRequest, Configuration, SocketIOClient, SocketIOServer}
import play.api.libs.json.{JsValue, Json}


class ChatServer() {

  var usernameToSocket: Map[String, SocketIOClient] = Map()
  var socketToUsername: Map[SocketIOClient, String] = Map()

  val config: Configuration = new Configuration {
    setHostname("localhost")
    setPort(8080)
  }

  val server: SocketIOServer = new SocketIOServer(config)

  server.addDisconnectListener(new DisconnectionListener(this))
  server.addEventListener("register", classOf[String], new RegisterListener(this))
  server.addEventListener("chat_message", classOf[String], new ChatMessageListener(this))

  server.start()

  def chatHistoryJSON():String = {
    val messages: List[ChatMessage] = ChatDatabase.accessFullChat()
    val messagesJSON: List[JsValue] = messages.map((message: ChatMessage) => message.asJsValue())
    Json.stringify(Json.toJson(messagesJSON))
  }

}

object ChatServer {
  def main(args: Array[String]): Unit = {
    new ChatServer()
  }
}



class RegisterListener(server: ChatServer) extends DataListener[String] {
  override def onData(socket: SocketIOClient, username: String, ackRequest: AckRequest): Unit = {
    println(username + " registered in the chat with socket " + socket)
    server.socketToUsername += (socket -> username)
    server.usernameToSocket += (username -> socket)
    socket.sendEvent("chat_history", server.chatHistoryJSON())
  }
}

class DisconnectionListener(server: ChatServer) extends DisconnectListener {
  override def onDisconnect(socket: SocketIOClient): Unit = {
    if(server.socketToUsername.contains(socket)){
      val username = server.socketToUsername(socket)
      server.socketToUsername -= socket
      server.usernameToSocket -= username
      println(username + " Disconnected")
    }
  }
}

class ChatMessageListener(server: ChatServer) extends DataListener[String] {
  override def onData(socket: SocketIOClient, message: String, ackRequest: AckRequest): Unit = {
    if(server.socketToUsername.contains(socket)) {
      val username = server.socketToUsername(socket)
      println("received message: " + message + " from " + username)
      ChatDatabase.storeMessage(username, message)
      server.server.getBroadcastOperations.sendEvent("chat_history", server.chatHistoryJSON())
    }
  }
}


