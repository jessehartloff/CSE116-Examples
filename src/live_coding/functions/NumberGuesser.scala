package live_coding.functions

object NumberGuesser {

  def guessTheNumber(lowerBound: Double,
                     upperBound: Double,
                     f: Double => Boolean): Double = {

    // base case: we have the answer within 0.01
    val midpoint = (lowerBound + upperBound) / 2.0
    if(upperBound - lowerBound < 0.01){
      midpoint
    }else {
      val higher = f(midpoint)
      if (higher) {
        guessTheNumber(midpoint, upperBound, f)
      } else {
        guessTheNumber(lowerBound, midpoint, f)
      }
    }
  }

}
