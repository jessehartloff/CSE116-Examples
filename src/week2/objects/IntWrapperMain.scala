package week2.objects

object IntWrapperMain {

  def main(args: Array[String]): Unit = {
    val one: IntWrapper = new IntWrapper
    val two: IntWrapper = new IntWrapper

    println(one.x)
    one.x = 7
    println(one.x)
    one.doubleX()

    // one and two have different internal states
    println(one.x)
    println(two.x)

  }

}
