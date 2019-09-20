package week4.json

import play.api.libs.json.{JsValue, Json}
import scalaj.http.Http


object ISS {

  def currentISSLocation(): Location = {

    // Use these lines to get the current location
    val url: String = "http://api.open-notify.org/iss-now.json"
    val response: String = Http(url).asString.body

    val parsed: JsValue = Json.parse(response)

    // unused values, but this is how we would extract message and timestamp
    val message: String = (parsed \ "message").as[String]
    val timestamp: Long = (parsed \ "timestamp").as[Long]

    val issLocation: Map[String, String] = (parsed \ "iss_position").as[Map[String, String]]

    val lat: Double = issLocation.getOrElse("latitude", "0.0").toDouble
    val lon: Double = issLocation.getOrElse("longitude", "0.0").toDouble

    new Location(lat, lon)
  }

  def createJSON(message: String, timestamp: Long, location: Location): String = {
    val jsonTimestamp: JsValue = Json.toJson(timestamp)
    val jsonMessage: JsValue = Json.toJson(message)

    val locationMap: Map[String, String] = Map(
      "latitude" -> location.latitude.toString,
      "longitude" -> location.longitude.toString
    )

    val jsonLocation: JsValue = Json.toJson(locationMap)

    val jsonMap: Map[String, JsValue] = Map(
      "timestamp" -> jsonTimestamp,
      "message" -> jsonMessage,
      "iss_position" -> jsonLocation
    )

    Json.stringify(Json.toJson(jsonMap))
  }

  def main(args: Array[String]): Unit = {

    val issLocation: Location = currentISSLocation()

    val location: Location = new Location(-36.5017, -2.8015)
    val issJSON: String = createJSON("success", 1550774961, location)

    println(issJSON)
  }

}