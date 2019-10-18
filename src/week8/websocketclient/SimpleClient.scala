package week8.websocketclient

import io.socket.client.{IO, Socket}
import io.socket.emitter.Emitter


class ProcessMessageFromServer() extends Emitter.Listener {
  override def call(objects: Object*): Unit = {
    val message = objects.apply(0).toString
    println(message)
  }
}


object SimpleClient{

  def main(args: Array[String]): Unit = {
    val socket: Socket = IO.socket("http://localhost:8080/")
    socket.on("ACK", new ProcessMessageFromServer())

    socket.connect()
    socket.emit("chat_message", "hello")
    socket.close()
  }
}
