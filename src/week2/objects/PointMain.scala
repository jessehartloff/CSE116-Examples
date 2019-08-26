package week2.objects

object PointMain {

  def main(args: Array[String]): Unit = {
    val p1: Point2D = new Point2D(3, 6)
    p1.x = 5

    println("(" + p1.x + ", " + p1.y + ")")
  }

}
