package week13

class Graph[A] {

  var nodes: Map[Int, A] = Map()
  var adjacencyList: Map[Int, List[Int]] = Map()


  def addNode(index: Int, a: A): Unit = {
    nodes += index -> a
    adjacencyList += index -> List()
  }

  def addEdge(index1: Int, index2: Int): Unit = {
    adjacencyList += index1 -> (index2 :: adjacencyList(index1))
    adjacencyList += index2 -> (index1 :: adjacencyList(index2))
  }

  def areConnected(index1: Int, index2: Int): Boolean = {
    // TODO: Does there exist a path between index1 and index2 in this graph?
    false
  }

  def distance(index1: Int, index2: Int): Int = {
    // TODO: Return the distance between index1 and index2 in this graph
    // You may assume that the two nodes are connected
    0
  }
}
