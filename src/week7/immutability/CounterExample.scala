package week7.immutability

object CounterExample {

  def updateCounter(n: Int, counter: ImmutableCounter): ImmutableCounter = {
    if(n==0){
      counter
    }else if(n < 0){
      updateCounter(n+1, counter.decrease())
    }else{
      updateCounter(n-1, counter.increase())
    }
  }

  def main(args: Array[String]): Unit = {

    val counter: ImmutableCounter = new ImmutableCounter(10)

    val counter2: ImmutableCounter = updateCounter(20, counter)
    val counter3: ImmutableCounter = updateCounter(-50, counter)

    counter.printCount()
    counter2.printCount()
    counter3.printCount()


    // Will this work? Give it a try!
//    val counter4: ImmutableCounter = updateCounter(1000000, counter)
//    counter4.printCount()
  }

}
