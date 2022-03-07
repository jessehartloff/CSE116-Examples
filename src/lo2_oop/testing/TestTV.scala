package lo2_oop.testing

import lo2_oop.state_pattern.tv.TV
import org.scalatest._

class TestTV extends FunSuite {

  test("play with remote") {

    val tv: TV = new TV()

    assert(tv.currentVolume() == 0)

    tv.volumeUp()

    assert(tv.currentVolume() == 0)

    tv.volumeDown()
    tv.volumeDown()

    assert(tv.currentVolume() == 0)

    tv.power()

    assert(tv.currentVolume() == 5)

    tv.volumeDown()
    assert(tv.currentVolume() == 4)
    tv.volumeUp()
    assert(tv.currentVolume() == 5)

    tv.mute()

    assert(tv.currentVolume() == 0)

    tv.volumeUp()
    assert(tv.currentVolume() == 5)

    tv.volumeUp()
    assert(tv.currentVolume() == 6)

    tv.volumeUp()
    assert(tv.currentVolume() == 7)

    tv.mute()
    assert(tv.currentVolume() == 0)
    tv.mute()
    assert(tv.currentVolume() == 7)

    tv.mute()
    assert(tv.currentVolume() == 0)
    tv.volumeDown()
    assert(tv.currentVolume() == 7)

    tv.mute()
    tv.power()
    assert(tv.currentVolume() == 0)

    tv.power()
    assert(tv.currentVolume() == 7)

    tv.volumeUp()

    tv.volumeUp()
    tv.volumeUp()
    assert(tv.currentVolume() == 10)
    tv.volumeUp()
    assert(tv.currentVolume() == 10)


    tv.volumeDown()
    assert(tv.currentVolume() == 9)
    tv.volumeDown()
    assert(tv.currentVolume() == 8)
    tv.volumeDown()
    assert(tv.currentVolume() == 7)
    tv.volumeDown()
    assert(tv.currentVolume() == 6)
    tv.volumeDown()
    assert(tv.currentVolume() == 5)
    tv.volumeDown()
    assert(tv.currentVolume() == 4)
    tv.volumeDown()
    assert(tv.currentVolume() == 3)
    tv.volumeDown()
    assert(tv.currentVolume() == 2)
    tv.volumeDown()
    assert(tv.currentVolume() == 1)
    tv.volumeDown()
    assert(tv.currentVolume() == 0)
    tv.volumeDown()
    assert(tv.currentVolume() == 0)
  }

}
