package lo1_program_execution.objects

object Anagrams {


  def isAnagram(s1: String, s2: String): Boolean = {
    s1.toLowerCase().replace(" ", "").toList.sorted == s2.toLowerCase().replace(" ", "").toList.sorted
  }


  def anagrams(input: String): List[String] ={
    var output: List[String] = List()
    if(input.isEmpty){
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
