package lo3_fp.concurrency.chat

import java.sql.{Connection, DriverManager, ResultSet}

object ChatDatabase {

  val url = "jdbc:mysql://localhost/mysql?serverTimezone=UTC"
  val username = "root"
  val password = "123456"

  var connection: Connection = DriverManager.getConnection(url, username, password)
  setupTable()

  def setupTable(): Unit = {
    val statement = connection.createStatement()
    statement.execute("CREATE TABLE IF NOT EXISTS chat (username TEXT, message TEXT)")
  }






  def sanitize(input: String): String = {
    input.replace("&", "&amp;")
      .replace("<", "&lt;")
      .replace(">", "&gt;")
  }



  def storeMessage(username: String, message: String): Unit = {

    val statement = connection.prepareStatement("INSERT INTO chat VALUE (?, ?)")

    statement.setString(1, sanitize(username))
    statement.setString(2, sanitize(message))

    statement.execute()
  }











  def accessFullChat(): List[ChatMessage] = {
    val statement = connection.prepareStatement("SELECT * FROM chat")
    val result: ResultSet = statement.executeQuery()

    var allMessages: List[ChatMessage] = List()

    while (result.next()) {
      val username = result.getString("username")
      val message = result.getString("message")
      allMessages = new ChatMessage(username, message) :: allMessages
    }

    allMessages
  }

}
