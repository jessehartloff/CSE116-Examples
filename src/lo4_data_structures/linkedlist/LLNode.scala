package lo4_data_structures.linkedlist

// Used for memory diagram to fit on slide
class LLNode[A](var value: A, var next: LLNode[A]) {

   def sizeTailRec(size: Int): Int = {
    if (this.next == null) {
      size + 1
    } else {
      this.next.sizeTailRec(size + 1)
    }
  }

  def size(): Int = {
    sizeTailRec(0)
  }

}
