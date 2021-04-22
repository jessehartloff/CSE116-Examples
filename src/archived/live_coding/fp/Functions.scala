package archived.live_coding.fp

object Functions {

  def histogram(inputData: List[Int]): Map[Int, Int] = {
    if(inputData.isEmpty){
      Map()
    }else{
      val elementToProcess: Int = inputData.head
      val nextList: List[Int] = inputData.drop(1)
      val histogramForNextList = histogram(nextList)
      if(histogramForNextList.contains(elementToProcess)){
        histogramForNextList + (elementToProcess -> (histogramForNextList(elementToProcess) + 1))
      }else{
        histogramForNextList + (elementToProcess -> 1)
      }
    }
  }


  def numberGuesser(min: Double, max: Double, f: Double => Boolean): Double = {
    numberGuesserHelper(Double.PositiveInfinity, min, max, f)
  }



  def numberGuesserHelper(previousGuess: Double, min: Double, max: Double, f: Double => Boolean): Double = {
    val currentGuess: Double = (min+max)/2.0
//    println(currentGuess)
    if(Math.abs(previousGuess - currentGuess) < 0.001){
      println("output:" + currentGuess + "\n")
      currentGuess
    }else{
      if(f(currentGuess)){
        // nextGuess is higher
        numberGuesserHelper(currentGuess, currentGuess, max, f)
      }else{
        // nextGuess should be lower
        numberGuesserHelper(currentGuess, min, currentGuess, f)
      }
    }
  }

}
