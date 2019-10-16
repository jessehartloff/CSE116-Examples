package week7.database

import java.sql.{Connection, DriverManager, ResultSet}

import physics.PhysicsVector

object Database {

  // adding "?serverTimezone=UTC" fixes a specific bug. You may be able to remove it on your system
  val url = "jdbc:mysql://localhost/mysql?serverTimezone=UTC"
  val username = "root"

  // irl don't hardcode your passwords if you are using version control
  // Use environment variables or settings files that are not checked into version control
  val password = "12345678"

  // You may need these lines to load the Driver class manually
  // Don't forget to add the mysql driver to your pom.xml file to download it
  //  val driver = "com.mysql.cj.jdbc.Driver"
  //  Class.forName(driver).newInstance()

  // Program will crash if this connection fails which will happen if MySQL is not running
  var connection: Connection = DriverManager.getConnection(url, username, password)


  //  def executeSQL(sqlString: String): Boolean = {
  //    val statement = connection.createStatement()
  //    statement.execute(sqlString)
  //  }
  //
  //  def executeSQLQuery(sqlString: String): ResultSet = {
  //    val statement = connection.createStatement()
  //    statement.executeQuery(sqlString)
  //  }


  def setupTable(): Unit = {
    val statement = connection.createStatement()

    // Don't do this in a real app. If the table exists all your data will be deleted.
    // We're doing this in testing to avoid duplicate entries
    statement.execute("DROP TABLE IF EXISTS players")
    statement.execute("CREATE TABLE players (username TEXT, points INT, locationX DOUBLE, locationY Double)")

    // Use in real app to avoid deleting your table
    //statement.execute("CREATE TABLE IF NOT EXISTS players (username TEXT, points INT, locationX DOUBLE, locationY Double)")
  }


  def createPlayer(username: String, startLocation: PhysicsVector): Unit = {
    val statement = connection.prepareStatement("INSERT INTO players VALUE (?, ?, ?, ?)")

    statement.setString(1, username)
    statement.setInt(2, 0)
    statement.setDouble(3, startLocation.x)
    statement.setDouble(4, startLocation.y)

    statement.execute()
  }


  def updatePlayer(username: String, startLocation: PhysicsVector, points: Int): Unit = {
    val statement = connection.prepareStatement("UPDATE players SET points = ?, locationX = ?, locationY = ? WHERE username = ?")

    statement.setInt(1, points)
    statement.setDouble(2, startLocation.x)
    statement.setDouble(3, startLocation.y)
    statement.setString(4, username)

    statement.execute()
  }


  def getPlayerScore(username: String): Int = {
    val statement = connection.prepareStatement("SELECT * FROM players WHERE username=?")
    statement.setString(1, username)
    val result: ResultSet = statement.executeQuery()

    result.next()
    result.getInt("points")
  }


  def getPlayerLocation(username: String): PhysicsVector = {
    val statement = connection.prepareStatement("SELECT * FROM players WHERE username=?")
    statement.setString(1, username)
    val result: ResultSet = statement.executeQuery()

    result.next()
    val x: Double = result.getDouble("locationX")
    val y: Double = result.getDouble("locationY")
    new PhysicsVector(x, y, 0.0)
  }


  def getAllScores(): Map[String, Int] = {
    val statement = connection.createStatement()
    val result: ResultSet = statement.executeQuery("SELECT * FROM players")

    var allScores: Map[String, Int] = Map()

    while (result.next()) {
      val username = result.getString("username")
      val score = result.getInt("points")
      allScores = allScores + (username -> score)
    }

    allScores
  }


}
