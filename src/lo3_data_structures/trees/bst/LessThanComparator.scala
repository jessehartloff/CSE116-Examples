package lo3_data_structures.trees.bst

class LessThanComparator extends Comparator[Int] {

  override def compare(a: Int, b: Int): Boolean = {
    a < b
  }

}
