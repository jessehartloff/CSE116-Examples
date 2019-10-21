package week9.mmo

import akka.actor.{Actor, ActorSystem, Props}
import com.corundumstudio.socketio.listener.{ConnectListener, DataListener, DisconnectListener}
import com.corundumstudio.socketio.{AckRequest, Configuration, SocketIOClient, SocketIOServer}
import play.api.libs.json.Json

import scala.concurrent.duration._

class MMOServer() extends Actor {

  var socketToCharacter: Map[SocketIOClient, CharacterObject] = Map()

  val config: Configuration = new Configuration {
    setHostname("localhost")
    setPort(8080)
  }

  val server: SocketIOServer = new SocketIOServer(config)

  server.addConnectListener(new ConnectionListener(this))
  server.addDisconnectListener(new DisconnectionListener(this))
  server.addEventListener("location", classOf[String], new LocationListener(this))

  server.start()

  def gameStateJSON(): String = {
    val playersJSON = socketToCharacter.keys.map((socket: SocketIOClient) => socketToCharacter(socket).asJsValue(socket.getSessionId.toString))

    val gameState = Map("players" -> playersJSON)

    Json.stringify(Json.toJson(gameState))
  }


  override def receive: Receive = {
    case Update =>
      server.getBroadcastOperations.sendEvent("gameState", gameStateJSON())
  }

}

object MMOServer {
  def main(args: Array[String]): Unit = {

    val system = ActorSystem("MMO_System")

    import system.dispatcher

    val mmo = system.actorOf(Props(classOf[MMOServer]))

    system.scheduler.schedule(0.milliseconds, 100.milliseconds, mmo, Update)
  }
}


class ConnectionListener(server: MMOServer) extends ConnectListener {
  override def onConnect(socket: SocketIOClient): Unit = {
    println("user connected: " + socket.getSessionId)
    server.socketToCharacter += socket -> new CharacterObject(0, 0)
  }
}

class DisconnectionListener(server: MMOServer) extends DisconnectListener {
  override def onDisconnect(socket: SocketIOClient): Unit = {
    println("user disconnected: " + socket.getSessionId)
    if (server.socketToCharacter.contains(socket)) {
      server.socketToCharacter -= socket
    }
  }
}

class LocationListener(server: MMOServer) extends DataListener[String] {
  override def onData(socket: SocketIOClient, message: String, ackRequest: AckRequest): Unit = {
    if (server.socketToCharacter.contains(socket)) {
      val character = server.socketToCharacter(socket)
      val location = Json.parse(message)
      character.x = (location \ "x").as[Int]
      character.y = (location \ "y").as[Int]
    }
  }
}


