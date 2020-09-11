package week2.testing

import org.scalatest._
import week2.objects.Item

class TestItems extends FunSuite {


  test("check Items"){

    val cereal: Item = new Item("cereal", 3.0)
    val milk: Item = new Item("milk", 2.0)

    assert(cereal.timesPurchased == 0)
    assert(milk.timesPurchased == 0)
    cereal.purchase()
    assert(cereal.timesPurchased == 1)
    cereal.purchase()
    assert(cereal.timesPurchased == 2)
    cereal.purchase()
    assert(cereal.timesPurchased == 3)
    assert(milk.timesPurchased == 0)

    cereal.onSale()

    assert(Math.abs(cereal.price - 2.4) < 0.0001)

    assert(cereal.isMoreExpensive(milk))
    assert(!milk.isMoreExpensive(cereal))

  }

}
