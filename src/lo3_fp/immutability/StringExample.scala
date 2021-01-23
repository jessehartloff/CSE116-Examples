package lo3_fp.immutability

object StringExample {

  def nerf(input: String): Unit = {
    input.replace("6", "5")
  }

  def amplify(input: String): String = {
//    input.replace("116", "250")
    "CSE250"
  }

  def main(args: Array[String]): Unit = {

    val course: String = "CSE116"
    nerf(course)
    val dataStructures: String = amplify(course)

    course + " is great!"
    val courseString = course + " is fun!"

    val anotherString: String = "CSE116"
    val listOfString: List[String] = List("CSE116", "CSE250", "CSE116 is fun!", "CSE116")

    println(course)
    println(dataStructures)
    println(courseString)
  }

}
