package week8.chat

import play.api.libs.json.{JsValue, Json}

object ChatMessage {

  def fromJSON(json: String): ChatMessage = {
    val jsonValue = Json.parse(json)
    val username = (jsonValue \ "username").as[String]
    val message = (jsonValue \ "message").as[String]
    new ChatMessage(username, message)
  }

}

class ChatMessage(val username: String, val message: String) {

  def asJsValue(): JsValue ={
    val messageMap: Map[String, JsValue] = Map("username" -> Json.toJson(username), "message" -> Json.toJson(message))
    Json.toJson(messageMap)
  }

}
