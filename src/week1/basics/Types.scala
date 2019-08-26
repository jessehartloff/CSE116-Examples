package week1.basics

object Types {

  def main(args: Array[String]): Unit = {

    // Declaring variable
    var anInt: Int = 10
    var aDouble: Double = 5.8
    var aBoolean: Boolean = true
    var aString: String = "6.3"

    // Converting variable types
    var anotherDouble: Double = aString.toDouble
    var anotherString: String = anInt.toString

    // Truncates the decimal. anotherInt == 5
    var anotherInt: Int = aDouble.toInt
  }

}
