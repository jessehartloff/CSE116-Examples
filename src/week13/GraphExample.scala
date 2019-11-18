package week13

object GraphExample {

  def main(args: Array[String]): Unit = {
    val graph: Graph[String] = new Graph()
    graph.addNode(0, "UCLA")
    graph.addNode(1, "STANFORD")
    graph.addNode(2, "SRI")
    graph.addNode(3, "UCSB")
    graph.addNode(4, "RAND")
    graph.addNode(5, "UTAH")
    graph.addNode(6, "SDC")
    graph.addNode(7, "MIT")
    graph.addNode(8, "BBN")
    graph.addNode(9, "LINCOLN")
    graph.addNode(10, "CARNEGIE")
    graph.addNode(11, "HARVARD")
    graph.addNode(12, "CASE")

    graph.addEdge(0,1)
    graph.addEdge(0,2)
    graph.addEdge(0,3)
    graph.addEdge(0,4)
    graph.addEdge(1,2)
    graph.addEdge(2,3)
    graph.addEdge(3,4)
    graph.addEdge(2,5)
    graph.addEdge(4,6)
    graph.addEdge(5,6)
    graph.addEdge(5,7)
    graph.addEdge(4,8)
    graph.addEdge(7,8)
    graph.addEdge(7,9)
    graph.addEdge(9,12)
    graph.addEdge(12,10)
    graph.addEdge(10,11)
    graph.addEdge(11, 8)

    BFS.bfs(graph, 0)
  }


}
