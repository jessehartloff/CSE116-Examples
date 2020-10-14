package live_coding.recursion

import org.scalatest._
import week2.objects.Item

class TestBinaryConversions extends FunSuite {

  test("Test Item") {

    val item: Item = new Item("Onions", 0.3)

    assert(item.description == "Onions")

    item.purchase()
    item.purchase()

    assert(item.timesPurchased == 2)


  }

}
