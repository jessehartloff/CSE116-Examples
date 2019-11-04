package week11

object QueueExample {


  def usingOurQueue(): Unit = {
    val queue = new Queue[Int]()
    queue.enqueue(3)
    queue.enqueue(7)
    queue.enqueue(2)
    queue.enqueue(-5)

    // queue is: 3, 7, 2, -5

    val element = queue.dequeue()
    println(element)
    // element is 3

    println(queue.front)
    // queue is: 7, 2, -5
  }

  def usingScalaQueue(): Unit = {
    val queue = scala.collection.mutable.Queue[Int]()
    queue.enqueue(3)
    queue.enqueue(7)
    queue.enqueue(2)
    queue.enqueue(-5)

    val element = queue.dequeue()
  }


  def main(args: Array[String]): Unit = {
    usingOurQueue()
    usingScalaQueue()
  }



}
