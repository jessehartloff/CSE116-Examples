package live_coding.lo3.b

import lo3_data_structures.graphs.Graph


object GraphExample {

  def example(): Unit = {
    val graph: Graph[GridLocation] = new Graph[GridLocation]()

    graph.addNode(0, new GridLocation(2, 5))
    graph.addNode(1, new GridLocation(2, 6))
    graph.addNode(2, new GridLocation(2, 4))
    graph.addNode(3, new GridLocation(3, 4))
    graph.addNode(4, new GridLocation(3, 5))

    graph.addEdge(1, 0)
    graph.addEdge(2, 0)
    graph.addEdge(4, 0)
    graph.addEdge(2, 3)
    graph.addEdge(3, 4)

    val startID: Int = 0
    val neighborsOfStart: List[Int] = graph.adjacencyList(startID)

    for (id <- neighborsOfStart) {
      val neighbors: List[Int] = graph.adjacencyList(id)
      println("the neighbors of " + graph.nodes(id) + " are " + neighbors)
    }

    println("done")
  }

  def main(args: Array[String]): Unit = {
    example()
  }

}
