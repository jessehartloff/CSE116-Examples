package week2.testing

import org.scalatest._
import week1.basics.Conditional

class TestComputeSize extends FunSuite {

  test("Doubles are checked for size in each category") {
    val largeDouble: Double = 70.0
    val mediumDouble: Double = 50.0
    val smallDouble: Double = 10.0

    assert(Conditional.computeSize(largeDouble) == "large", largeDouble)
    assert(Conditional.computeSize(mediumDouble) == "medium", mediumDouble)
    assert(Conditional.computeSize(smallDouble) == "small", smallDouble)
  }


  test("Size boundaries are checked"){
    val largeDouble: Double = 60.0
    val mediumDoubleUpperBound: Double = 59.99
    val mediumDoubleLowerBound: Double = 30.0
    val smallDouble: Double = 29.99

    assert(Conditional.computeSize(largeDouble) === "large", largeDouble)
    assert(Conditional.computeSize(mediumDoubleUpperBound) == "medium", mediumDoubleUpperBound)
    assert(Conditional.computeSize(mediumDoubleLowerBound) == "medium", mediumDoubleLowerBound)
    assert(Conditional.computeSize(smallDouble) == "small", smallDouble)
  }


  test("Use many test cases for each category"){
    // notice largeDoubles must be declared with var we change its value
    var largeDoubles: List[Double] = List(60.0, 60.01, 70.0, 90.0, 1000.0)
    val mediumDoubles: List[Double] = List(59.9, 30.0, 30.01, 40.0, 50.0)
    val smallDoubles: List[Double] = List(29.99, 20.0, 10.0, 0.0, -100.0, -10000.0)

    largeDoubles = largeDoubles :+ 10000.0 // Example of adding an element to a List

    for(largeDouble <- largeDoubles){
      assert(Conditional.computeSize(largeDouble) == "large", largeDouble)
    }
    for(mediumDouble <- mediumDoubles){
      assert(Conditional.computeSize(mediumDouble) == "medium", mediumDouble)
    }
    for(smallDouble <- smallDoubles){
      assert(Conditional.computeSize(smallDouble) == "small", smallDouble)
    }

  }

}
