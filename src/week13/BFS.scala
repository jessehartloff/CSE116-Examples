package week13

import week11.Queue

object BFS {

  def bfs[A](graph: Graph[A], startID: Int): Unit = {

    var explored: Set[Int] = Set(startID)

    val toExplore: Queue[Int] = new Queue()
    toExplore.enqueue(startID)

    while (!toExplore.empty()) {
      val nodeToExplore = toExplore.dequeue()
      for (node <- graph.adjacencyList(nodeToExplore)) {
        if(!explored.contains(node)){
          println("exploring: " + graph.nodes(node))
          toExplore.enqueue(node)
          explored = explored + node
        }
      }
    }
  }

}
