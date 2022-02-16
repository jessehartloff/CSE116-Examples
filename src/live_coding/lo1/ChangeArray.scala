package live_coding.lo1

object ChangeArray {

  // write a method named timesTwo that takes an array of Ints
  // and multiplies all the values in the Array by 2,
  // then returns the sum of all the values after they are multiplied as an Int

  def intTimesTwo(x: Int): Int = {
    x * 2
  }

  def timesTwo(parameter: Array[Int]): Int = {
    var sum: Int = 0
    for (i <- parameter.indices) {
      parameter(i) = intTimesTwo(parameter(i))
      println(parameter(i))
      sum += parameter(i)
    }
    sum
  }

  def main(args: Array[String]): Unit = {
    val argument: Array[Int] = Array(2, 5, -3)
    val result: Int = timesTwo(argument)
    println(result)
  }

}
