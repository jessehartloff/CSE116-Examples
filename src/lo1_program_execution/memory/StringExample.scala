package lo1_program_execution.memory

object StringExample {

  def reverse(input: String): String = {
    var result = ""
    for(i <- input.indices){
      result = input(i) + result
    }
    result
  }

  def modify(input: String): String = {
    var result: String = ""
    for(i <- 1 until input.length){
      result += input(i)
    }
    result = reverse(result)
    result
  }

  def main(args: Array[String]): Unit = {
    var word: String = "dog"
    word = modify(word)
    println(word)
  }

}
