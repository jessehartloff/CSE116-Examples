package lo3_fp.functions

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
    val numbers: List[Double] = List()
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
    val product: Double = numbers.fold(1.0)(_ * _)
    println(product)
  }


  def sumExample(): Unit = {
    val numbers: List[Double] = List(1.0, 2.0, 3.0, 4.0, 5.0)
    val sum: Double = numbers.sum
    println(sum)
  }


  def changeTypesExample(): Unit = {
    val words: List[String] = List("zero", "one", "two", "three")
    val totalLength: Int = words.foldLeft(0)(_ + _.length)
    val totalLength2: Int = words.foldRight(0)(_.length + _)
    println(totalLength)
    println(totalLength2)
  }


  def distinctExample(): Unit = {
    val numbers: List[Int] = List(1, 1, 2, 2, 2, 3, 4, 4, 5)
    val distinctElements: List[Int] = numbers.distinct
    println(distinctElements)
  }


  def sliceExample(): Unit = {
    val numbers: List[Int] = List(0, 10, 20, 30, 40, 50, 60)
    val slicedElements: List[Int] = numbers.slice(1, 4)
    println(slicedElements)
  }

  def reverseExample(): Unit = {
    val numbers: List[Int] = List(0, 10, 20, 30, 40, 50, 60)
    val reversed: List[Int] = numbers.reverse
    println(reversed)
  }


  def main(args: Array[String]): Unit = {

    //    forEachExample()
    //    filterExample()
    //    mapExample()
    //    mapExample2()
    //    yieldExample()
    //    yieldExample2()
        reduceExample()
    //    reduceExample2()
    //    foldExample()
    //    sumExample()
    //    distinctExample()
    //    sliceExample()
//    reverseExample()
    //    changeTypesExample()

  }
}
