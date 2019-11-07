package project.backend.overworldsystem

import akka.actor.{Actor, ActorRef, ActorSystem, Props}
import project.backend._
import com.corundumstudio.socketio.{AckRequest, Configuration, SocketIOClient, SocketIOServer}
import play.api.libs.json.Json


class OverworldTestServer() extends Actor {

  val overworldSystem: ActorRef = this.context.actorOf(Props(classOf[OverworldSystem], self))

  var socketToPartyId: Map[SocketIOClient, String] = Map()

  val config: Configuration = new Configuration {
    setHostname("localhost")
    setPort(8080)
  }

  val server: SocketIOServer = new SocketIOServer(config)

  var overworldMapJSON: String = ""


  server.addConnectListener(
    (socket: SocketIOClient) => {
      val partyId = "party_" + (Math.random() * 10000).intValue()
      socket.sendEvent("yourPartyId", partyId)
      socket.sendEvent("overworldMap", overworldMapJSON)
      socketToPartyId += socket -> partyId
      overworldSystem ! AddParty(partyId, "")
    }
  )

  server.addDisconnectListener(
    (socket: SocketIOClient) => {
      overworldSystem ! RemoveParty(socketToPartyId(socket))
      socketToPartyId -= socket
    }
  )


  server.addEventListener("overworldMovement", classOf[String],
    (socket: SocketIOClient, data: String, _: AckRequest) => {
      val partyId = socketToPartyId(socket)
      val dataParsed = Json.parse(data)
      val x = (dataParsed \ "x").as[Double]
      val y = (dataParsed \ "y").as[Double]
      if (Math.abs(x) < 0.001 && Math.abs(y) < 0.001) {
        overworldSystem ! StopParty(partyId)
      } else {
        overworldSystem ! MoveParty(partyId, x, y)
      }
    }
  )


  server.start()

  override def postStop(): Unit = {
    println("stopping server")
    server.stop()
  }


  import context.dispatcher
  import scala.concurrent.duration._

  override def receive: Receive = {


    case update: Update =>
      overworldSystem ! update

    /*** From OverworldSystem ***/
    case overworldMap: OverworldMap => overworldMapJSON = overworldMap.mapJSON
    case overworldState: OverworldState =>
      server.getBroadcastOperations.sendEvent("overworldState", overworldState.overworldStateJSON)
    case battleStarted: BattleStarted =>
      // Simulate the battle by randomly selecting a winner and sending the result back to the overworld in 5 seconds
      val battleEnd: BattleEnded = if (Math.random() < 0.5) {
        BattleEnded(battleStarted.partyId1, battleStarted.partyId2)
      } else {
        BattleEnded(battleStarted.partyId2, battleStarted.partyId1)
      }
      context.system.scheduler.scheduleOnce(5000.milliseconds, overworldSystem, battleEnd)

  }

}



object OverworldTestServer {

  def main(args: Array[String]): Unit = {
    val actorSystem = ActorSystem()

    import actorSystem.dispatcher

    import scala.concurrent.duration._

    val server = actorSystem.actorOf(Props(classOf[OverworldTestServer]))

    actorSystem.scheduler.schedule(0.milliseconds, 33.milliseconds, server, Update(System.nanoTime()))
  }
}