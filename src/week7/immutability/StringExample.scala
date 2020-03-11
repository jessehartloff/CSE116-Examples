package week7.immutability

object StringExample {

  def nerf(input: String): Unit = {
    input.replace("6", "5")
  }

  def amplify(input: String): String = {
    input.replace("116", "250")
  }

  def main(args: Array[String]): Unit = {

    val course: String = "CSE116"
    nerf(course)
    val dataStructures: String = amplify(course)

    course + " is great!"
    val courseString = course + " is fun!"

    println(course)
    println(dataStructures)
    println(courseString)
  }

}
