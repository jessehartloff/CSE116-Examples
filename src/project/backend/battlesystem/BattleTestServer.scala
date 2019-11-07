package project.backend.battlesystem

import akka.actor.{Actor, ActorRef, ActorSystem, Props}
import com.corundumstudio.socketio.{AckRequest, Configuration, SocketIOClient, SocketIOServer}
import play.api.libs.json.Json
import project.backend._


class BattleTestServer() extends Actor {

  val battleSystem: ActorRef = this.context.actorOf(Props(classOf[BattleSystem], self))

  var socketToPartyId: Map[SocketIOClient, String] = Map()
  var partyIdToSocket: Map[String, SocketIOClient] = Map()

  val config: Configuration = new Configuration {
    setHostname("localhost")
    setPort(8080)
  }

  val server: SocketIOServer = new SocketIOServer(config)

  server.addConnectListener(
    (socket: SocketIOClient) => {
      val partyId = "party_" + (Math.random() * 10000).intValue()
      socket.sendEvent("yourPartyId", partyId)
      socketToPartyId += socket -> partyId
      partyIdToSocket += partyId -> socket
      battleSystem ! AddParty(partyId, "" /* TODO: Generate a JSON string representing a party in a format you decide */)
    }
  )

  server.addDisconnectListener(
    (socket: SocketIOClient) => {
      battleSystem ! RemoveParty(socketToPartyId(socket))
      partyIdToSocket -= socketToPartyId(socket)
      socketToPartyId -= socket
    }
  )


  server.addEventListener("battleAction", classOf[String],
    (socket: SocketIOClient, data: String, _: AckRequest) => {
      val partyId = socketToPartyId(socket)
      val dataParsed = Json.parse(data)
      val action = (dataParsed \ "action").as[String]
      val sourceName = (dataParsed \ "source").as[String]
      val targetName = (dataParsed \ "target").as[String]
      battleSystem ! TurnAction(partyId, sourceName, targetName, action)
    }
  )

  server.addEventListener("startBattle", classOf[String],
    (socket: SocketIOClient, data: String, _: AckRequest) => {
      val partyId = socketToPartyId(socket)
      val targetPartyId = data
      println("fight!")
      battleSystem ! BattleStarted(partyId, targetPartyId)
    }
  )

  server.start()

  override def postStop(): Unit = {
    println("stopping server")
    server.stop()
  }


  override def receive: Receive = {

    case update: Update =>
      server.getBroadcastOperations.sendEvent("allParties", Json.stringify(Json.toJson(partyIdToSocket.keys)))
      battleSystem ! update

    case battleEnd: BattleEnded =>
      partyIdToSocket(battleEnd.losingPartyId).sendEvent("battleEnded")
      partyIdToSocket(battleEnd.winningPartyId).sendEvent("battleEnded")
    case battleState: BattleState =>
      partyIdToSocket(battleState.partyId1).sendEvent("battleState", Json.stringify(Json.toJson(
        Map("playerParty" -> battleState.partyJSON1, "enemyParty" -> battleState.partyJSON2)
      )))
      partyIdToSocket(battleState.partyId2).sendEvent("battleState", Json.stringify(Json.toJson(
        Map("playerParty" -> battleState.partyJSON2, "enemyParty" -> battleState.partyJSON1)
      )))
    case turnReady: CharacterTurnReady =>
      partyIdToSocket(turnReady.partyId).sendEvent("turnReady", turnReady.characterName)
    case action: AnimateAction =>
      val message = Json.stringify(Json.toJson(Map(
        "source" -> Json.toJson(action.sourceName),
        "target" -> Json.toJson(action.targetName),
        "deltaHP" -> Json.toJson(action.deltaHP)
      )))
      partyIdToSocket(action.sourcePartyId).sendEvent("actionTaken", message)
      partyIdToSocket(action.targetPartyId).sendEvent("actionTaken", message)

  }

}


object BattleTestServer {

  def main(args: Array[String]): Unit = {
    val actorSystem = ActorSystem()

    import actorSystem.dispatcher

    import scala.concurrent.duration._

    val server = actorSystem.actorOf(Props(classOf[BattleTestServer]))

    actorSystem.scheduler.schedule(0.milliseconds, 33.milliseconds, server, Update(System.nanoTime()))
  }
}
