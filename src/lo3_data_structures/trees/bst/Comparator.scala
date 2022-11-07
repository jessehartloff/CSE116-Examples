package lo3_data_structures.trees.bst

trait Comparator[T] {

  def compare(a: T, b: T): Boolean

}
