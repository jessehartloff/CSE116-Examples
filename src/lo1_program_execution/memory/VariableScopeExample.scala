package lo1_program_execution.memory

object VariableScopeExample {

  def isNegative(x: Int): Boolean = {
    var y: Boolean = false
    if (x < 0) {
      y = true
    } else {
      var y = true
    }
    y
  }


  def divide(x: Int, y: Int): Int = {

    var z: Int = 0
    var w: Int = 0

    while (w <= Math.abs(x)) {
      w += Math.abs(y)
      z += 1
    }

    if (z != 0) {
      z -= 1
    }

    if (isNegative(x) ^ isNegative(y)) {
      // ^ is a boolean xor
      -z
    } else {
      z
    }

  }


  def subtract(x: Int, y: Int): Int = {
    var z: Int = x
    for (i <- 0 until Math.abs(y)) {
      val x: Int = 20
      if (isNegative(y)) {
        val x: Int = 1
        z += x
      } else {
        val x: Int = 1
        z -= x
      }
    }
    z
  }




  def factorial(x: Int): Int = {
    var y: Int = Math.abs(x)
    var z: Int = 1

    while (y > 0) {
      z *= y
      y -= 1
    }

    z
  }

  def permute(x: Int, y: Int): Int = {
    if (y > x) {
      0
    } else {
      val w: Int = subtract(x, y)
      val z: Int = factorial(w)
      divide(factorial(x), z)
    }
  }


  def main(args: Array[String]): Unit = {
    val x: Int = 5
    val y: Int = 3
    val z: Int = permute(x, y)
    println(z)
  }

}
