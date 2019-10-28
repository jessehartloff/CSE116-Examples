package week10.sorting

import physics.PhysicsVector

object CustomSorting {

  def distance(v1: PhysicsVector, v2: PhysicsVector): Double = {
    Math.sqrt(Math.pow(v1.x - v2.x, 2.0) + Math.pow(v1.y - v2.y, 2.0) + Math.pow(v1.z - v2.z, 2.0))
  }

  def distanceComparator(referencePoint: PhysicsVector): (PhysicsVector, PhysicsVector) => Boolean = {
    (v1: PhysicsVector, v2: PhysicsVector) => {
      distance(v1, referencePoint) < distance(v2, referencePoint)
    }
  }

  def example(n: Int): Unit = {

    // Generate random vectors
    val points: List[PhysicsVector] = (for (i <- 0 to n) yield {
      new PhysicsVector(Math.random(), Math.random(), Math.random())
    }).toList

    val referencePoint = new PhysicsVector(0.5, 0.5, 0.0)
    val sortedPoints = MergeSort.mergeSort(points, distanceComparator(referencePoint))
    sortedPoints.foreach(println)
  }

  def main(args: Array[String]): Unit = {
    example(10)
  }

}
