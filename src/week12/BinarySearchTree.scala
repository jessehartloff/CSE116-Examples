package week12

class BinarySearchTree[A](comparator: (A, A) => Boolean) {

  var root: BinaryTreeNode[A] = null

  def insert(a: A): Unit = {
    if(this.root == null){
      this.root = new BinaryTreeNode(a, null, null)
    }else{
      insertHelper(a, this.root)
    }
  }

  def insertHelper(a: A, node: BinaryTreeNode[A]): Unit = {
    if(comparator(node.value, a)){
      if(node.right == null){
        node.right = new BinaryTreeNode[A](a, null, null)
      }else{
        insertHelper(a, node.right)
      }
    }else{
      if(node.left == null){
        node.left = new BinaryTreeNode[A](a, null, null)
      }else{
        insertHelper(a, node.left)
      }
    }
  }

  def find(a: A): BinaryTreeNode[A] = {
    findHelper(a, this.root)
  }

  def findHelper(a: A, node: BinaryTreeNode[A]): BinaryTreeNode[A] = {
    if(node == null){
      null
    }else if(comparator(a, node.value)){
      findHelper(a, node.left)
    }else if(comparator(node.value, a)){
      findHelper(a, node.right)
    }else{
      node
    }
  }


  def toList: List[A] = {
    List()
  }

}
