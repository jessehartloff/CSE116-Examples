package week6.functions

object Examples {

  def forEachExample(): Unit = {

    val words: List[String] = List("zero", "one", "two", "three")
    words.foreach(println)

  }


  def filterExample(): Unit = {

    val words: List[String] = List("zero", "one", "two", "three")
    val filteredWords: List[String] = words.filter(_.length > 3)
    filteredWords.foreach(println)

  }


  def mapExample(): Unit = {
    val numbers: List[Double] = List(1.0, 2.0, 3.0, 4.0, 5.0)
    val numbersSquared: List[Double] = numbers.map(Math.pow(_, 2.0))
    numbersSquared.foreach(println)
  }


  def mapExample2(): Unit = {
    val words: List[String] = List("zero", "one", "two", "three")
    val wordLengths: List[Int] = words.map(_.length)
    wordLengths.foreach(println)
  }

  def reduceExample(words: List[String]): String = {
    words.reduce((a: String, b: String) => a + " AND " + b)
  }


  def yieldExample(): Unit = {
    val numbers: List[Double] = List(1.0, 2.0, 3.0, 4.0, 5.0)
    val numbersSquared: List[Double] = for (number <- numbers) yield {
      Math.pow(number, 2.0)
    }
    numbersSquared.foreach(println)
  }

  def yieldExample2(): Unit = {
    val numbersSquared: List[Double] = (for (number <- 1 to 5) yield {
      Math.pow(number, 2.0)
    }).toList
    numbersSquared.foreach(println)
  }


  def reduceExample(): Unit = {
    val numbers: List[Double] = List(1.0, 2.0, 3.0, 4.0, 5.0)
    val sumSquares: (Double, Double) => Double = (a: Double, b: Double) => a + Math.pow(b, 2.0)
    val sumOfSquares: Double = numbers.reduce(sumSquares)
    println(sumOfSquares)
  }

  def reduceExample2(): Unit = {
    val numbers: List[Double] = List(1.0, 2.0, 3.0, 4.0, 5.0)
    val sumOfSquares: Double = numbers.reduce(_ + Math.pow(_, 2.0))
    println(sumOfSquares)
  }


  def foldExample(): Unit = {
    val numbers: List[Double] = List(1.0, 2.0, 3.0, 4.0, 5.0)
    val factorial: Double = numbers.fold(1.0)(_ * _)
    println(factorial)
  }


  def main(args: Array[String]): Unit = {

    //    forEachExample()
    //    filterExample()
    //    mapExample()
    //    mapExample2()
    //    yieldExample()
    //    yieldExample2()
//    reduceExample()
//    reduceExample2()
    foldExample()

  }
}
