package week8.websocketserver

import com.corundumstudio.socketio.listener.{ConnectListener, DataListener, DisconnectListener}
import com.corundumstudio.socketio.{AckRequest, Configuration, SocketIOClient, SocketIOServer}


class Server() {

  val config: Configuration = new Configuration {
    setHostname("localhost")
    setPort(8080)
  }

  val server: SocketIOServer = new SocketIOServer(config)

  server.addConnectListener(new ConnectionListener())
  server.addDisconnectListener(new DisconnectionListener())
  server.addEventListener("chat_message", classOf[String], new MessageListener())
  server.addEventListener("stop_server", classOf[Nothing], new StopListener(this))

  server.start()
}

object Server {
  def main(args: Array[String]): Unit = {
    new Server()
  }
}


class ConnectionListener() extends ConnectListener {
  override def onConnect(client: SocketIOClient): Unit = {
    println("Connected: " + client)
  }
}


class DisconnectionListener() extends DisconnectListener {
  override def onDisconnect(socket: SocketIOClient): Unit = {
    println("Disconnected: " + socket)
  }
}


class MessageListener() extends DataListener[String] {
  override def onData(socket: SocketIOClient, data: String, ackRequest: AckRequest): Unit = {
    println("received message: " + data + " from " + socket)
    socket.sendEvent("ACK", "I received your message of " + data)
  }
}

class StopListener(server: Server) extends DataListener[Nothing] {
  override def onData(socket: SocketIOClient, data: Nothing, ackRequest: AckRequest): Unit = {
    server.server.getBroadcastOperations.sendEvent("server_stopped")
    println("stopping server")
    server.server.stop()
  }
}

