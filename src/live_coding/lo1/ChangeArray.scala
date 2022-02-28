package live_coding.lo1

object ChangeArray {

  // write a method named timesTwo that takes an array of Ints
  // and multiplies all the values in the Array by 2,
  // then returns the sum of all the values after they are multiplied as an Int
  def timesTwo(input: Array[Int]): Int = {
    var acc: Int = 0
    for (index <- input.indices) {
      input(index) = input(index) * 2
      acc += input(index)
    }
    acc
  }


  def main(args: Array[String]): Unit = {
    val argument: Array[Int] = Array(2, 5, -3)
    val result: Int = timesTwo(argument)
    println(result)
  }

}
