package lo2_oop.state_pattern.tv

object TVMain {


  def main(args: Array[String]): Unit = {
    val tv: TV = new TV()
    tv.volumeUp()
    println(tv.currentVolume())
    tv.power()
    tv.volumeUp()
    println(tv.currentVolume())
  }


}
