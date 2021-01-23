package lo1_program_execution.testing

import org.scalatest._
import lo1_program_execution.objects.Item

class TestItem extends FunSuite {

  test("Test Item") {

    val item: Item = new Item("Onions", 0.3)

    assert(item.description == "Onions")

    item.purchase()
    item.purchase()

    assert(item.timesPurchased == 2)


  }

}
