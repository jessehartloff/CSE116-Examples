package lo2_oop.state_pattern.tv

object TVMain {


  def main(args: Array[String]): Unit = {

    val tv: TV = new TV()

    tv.volumeUp()

    tv.power()

    tv.volumeUp()

    tv.mute()

    println(tv.currentVolume())

    tv.volumeUp()
    println(tv.currentVolume())

    tv.volumeUp()
    println(tv.currentVolume())

    tv.volumeUp()
    println(tv.currentVolume())

    tv.mute()
    println(tv.currentVolume())
    tv.mute()
    println(tv.currentVolume())

    tv.mute()
    println(tv.currentVolume())
    tv.volumeDown()
    println(tv.currentVolume())

    tv.mute()
    tv.power()
    println(tv.currentVolume())

    tv.power()
    println(tv.currentVolume())

    tv.volumeUp()

    tv.volumeUp()
    tv.volumeUp()
    println(tv.currentVolume())
    tv.volumeUp()
    println(tv.currentVolume())


    tv.volumeDown()
    println(tv.currentVolume())
    tv.volumeDown()
    println(tv.currentVolume())
    tv.volumeDown()
    println(tv.currentVolume())
    tv.volumeDown()
    println(tv.currentVolume())
    tv.volumeDown()
    println(tv.currentVolume())
    tv.volumeDown()
    println(tv.currentVolume())
    tv.volumeDown()
    println(tv.currentVolume())
    tv.volumeDown()
    println(tv.currentVolume())
    tv.volumeDown()
    println(tv.currentVolume())
    tv.volumeDown()
    println(tv.currentVolume())
    tv.volumeDown()
    println(tv.currentVolume())
  }


}
