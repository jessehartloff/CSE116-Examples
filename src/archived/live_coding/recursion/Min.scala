package archived.live_coding.recursion

object Min {

  /** *
   * Find the input of the minimum output for a function
   *
   * @param f the function to minimize that takes 1 real number and returns a real number
   * @return The input value with the minimum output
   */
  def minOfFunction(f: Double => Double): Double = {
    minHelper(f, 0.0, 1.0)
  }

  def minHelper(f: Double => Double, xMinFound: Double, stepSize: Double): Double = {
    if (stepSize < 0.0001) {
      xMinFound
    } else if (f(xMinFound) > 10000000.0) {
      Double.PositiveInfinity
    } else if (f(xMinFound) < -10000000.0) {
      Double.NegativeInfinity
    } else {
      val forward: Double = f(xMinFound + stepSize)
      val current: Double = f(xMinFound)
      val backward: Double = f(xMinFound - stepSize)
      if (current < forward && current < backward) {
        // narrow the search
        // decrease the stepSize by 1/2
        minHelper(f, xMinFound, stepSize / 2.0)
      } else if (forward < backward) {
        // move forward
        minHelper(f, xMinFound + stepSize, stepSize)
      } else {
        // more backward
        minHelper(f, xMinFound - stepSize, stepSize)
      }
    }

  }

}
