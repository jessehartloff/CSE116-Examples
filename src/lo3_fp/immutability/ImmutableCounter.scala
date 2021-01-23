package lo3_fp.immutability

/***
  * Note: The internal counter cannot change or be accessed from outside this class
  */
class ImmutableCounter(counter: Int) {

  // This method only exists for the example so we can view the value of counter but can't access it
  def printCount():Unit = {
    println(this.counter)
  }

  def increase(): ImmutableCounter = {
    new ImmutableCounter(this.counter + 1)
  }

  def decrease(): ImmutableCounter = {
    new ImmutableCounter(this.counter - 1)
  }

}
