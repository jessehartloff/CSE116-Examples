package archived.lo3

import scala.annotation.tailrec

object NumberGuesser {

  // f will return true if the hidden number is higher than the one you guessed
  //  false if the number is lower of equal
  def guessTheNumber(lowerBound: Double,
                     upperBound: Double,
                     f: Double => Boolean): Double = {
    val epsilon: Double = 0.01
    val midpoint: Double = (upperBound + lowerBound) / 2.0
    if(upperBound - lowerBound < epsilon){
      midpoint
    }else{
      val higher: Boolean = f(midpoint)
      val answer = if(higher){
        guessTheNumber(midpoint, upperBound, f)
      }else{
        guessTheNumber(lowerBound, midpoint, f)
      }
      answer
     }

  }

}
