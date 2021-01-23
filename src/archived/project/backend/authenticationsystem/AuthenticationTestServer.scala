package archived.project.backend.authenticationsystem

import akka.actor.{Actor, ActorRef, Props}
import com.corundumstudio.socketio.{Configuration, SocketIOServer}


class AuthenticationTestServer() extends Actor {

  // Very little setup is provided for authentication. If you are completing authentication for your team
  // you must also design and implement a socket server and front end for your demo that will allow you to
  // to prove that all the required functionality is implemented


  val authenticationSystem: ActorRef = this.context.actorOf(Props(classOf[AuthenticationSystem]))

  val config: Configuration = new Configuration {
    setHostname("localhost")
    setPort(8080)
  }

  val server: SocketIOServer = new SocketIOServer(config)

  override def receive: Receive = {

    case _ =>

  }


  override def postStop(): Unit = {
    println("stopping server")
    server.stop()
  }

}



