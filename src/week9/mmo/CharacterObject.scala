package week9.mmo

import play.api.libs.json.{JsValue, Json}

class CharacterObject(var x: Int, var y: Int) {

  def asJsValue(id: String = ""): JsValue ={
    var messageMap: Map[String, JsValue] = Map("x" -> Json.toJson(x), "y" -> Json.toJson(y))
    if(id != ""){
      messageMap += "id" -> Json.toJson(id)
    }
    Json.toJson(messageMap)
  }

}