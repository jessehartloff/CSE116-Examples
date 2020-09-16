package week2.objects

object Anagrams {

  def anagrams(input: String): List[String] ={
    var output: List[String] = List()
    if(input.length() == 0){
      List()
    }else if(input.length() == 1){
      List(input)
    }else {
      for(index <- input.indices){
        val ch: Char = input.charAt(index)
        val newString: String = input.substring(0,index) + input.substring(index+1, input.length())
        val anagramsOfNewString: List[String] = anagrams(newString)
        for(anagram <- anagramsOfNewString){
          val potentialAnagram: String = anagram + ch
          if(!output.contains(potentialAnagram)){
            output = potentialAnagram :: output
          }
        }
      }
      output
    }
  }

}
