package live_coding.lo3.a

import lo3_data_structures.graphs.Graph

object GraphExample {

  def example(): Unit = {
    val graph: Graph[Point] = new Graph()

    graph.addNode(0, new Point(4, 5))
    graph.addNode(1, new Point(4, 6))
    graph.addNode(2, new Point(4, 4))
    graph.addNode(3, new Point(5, 6))

    graph.addEdge(0, 1)
    graph.addEdge(1, 3)
    graph.addEdge(0, 2)

    val startNode: Int = 1
    val neighbors: List[Int] = graph.adjacencyList(startNode)

    for (id <- neighbors) {
      val neighbors: List[Int] = graph.adjacencyList(id)
      println("the neighbors of " + id + " are " + neighbors)
    }

    println(graph.adjacencyList.get(0))

    println("done")
  }

  def main(args: Array[String]): Unit = {
    example()
  }

}
