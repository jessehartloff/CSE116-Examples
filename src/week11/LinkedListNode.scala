package week11

import scala.annotation.tailrec

// Simple Linked List implementation (note: Cannot represent empty list)
class LinkedListNode[A](var value: A, var next: LinkedListNode[A]) {


  /**
    * prepend an new node to the beginning of the list with the given value and returns a reference to the new node
    */
  def prepend(a: A): LinkedListNode[A] = {
    new LinkedListNode[A](a, this)
  }

  /**
    * returns the number of nodes in the list starting with this node
    */
  def size(): Int = {
    if(this.next == null){
      1
    }else{
      this.next.size() + 1
    }
  }

  /**
    * Returns the (i+1)th node in the list
    *
    * Made to simulate array access notation
    */
  def apply(i: Int): LinkedListNode[A] = {
    if (i == 0) {
      this
    } else {
      this.next.apply(i - 1)
    }
  }


  /**
    * Insert an element after this node in the list
    */
  def insert(element: A): Unit = {
    this.next = new LinkedListNode[A](element, this.next)
  }


  /**
    * Delete the node after this node from the list
    */
  def deleteAfter(): Unit = {
    this.next = this.next.next
  }

  /**
    * returns the first node in the list containing the value toFind. Returns null if toFind is not in the list
    */
  @tailrec
  final def find(toFind: A): LinkedListNode[A] = {
    if (this.value == toFind) {
      this
    } else if (this.next == null) {
      null
    } else {
      this.next.find(toFind)
    }
  }

  // same functionality as find, but uses a loop instead of recursion. Provided for a comparison between
  // a recursive and an iterative solution
  def findIterative(toFind: A): LinkedListNode[A] = {
    var node = this
    while (node != null) {
      if (node.value == toFind) {
        return node
      }
      node = node.next
    }
    null
  }


  /**
    * returns the head of a new linked list containing f(element) for each element in the original list
    */
  def map[B](f: A => B): LinkedListNode[B] = {
    val newValue = f(this.value)
    if (this.next == null) {
      new LinkedListNode[B](newValue, null)
    } else {
      new LinkedListNode[B](newValue, this.next.map(f))
    }
  }

  /**
    * calls the provided function on every element in the list
    */
  def foreach(f: A => Unit): Unit = {
    f(this.value)
    if(this.next != null) {
      this.next.foreach(f)
    }
  }


  override def toString: String = {
    List()
    if (this.next == null) {
      this.value.toString
    }else {
      this.value.toString + ", " + this.next.toString
    }
  }




}
