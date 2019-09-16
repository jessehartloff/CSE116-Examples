package physics

/**
  * A 3-Dimension vector in the physical space. The x/y plane is parallel to the ground and the z-axis is perpendicular
  * to the ground. Gravity is applied in the negative z direction (ie. positive z is up)
  *
  * @param x magnitude of the vector in the x direction
  * @param y magnitude of the vector in the y direction
  * @param z magnitude of the vector in the z direction
  */
class PhysicsVector(var x: Double = 0.0, var y: Double = 0.0, var z: Double = 0.0) {

  override def toString: String = {
    "(" + x + ", " + y + ", " + z + ")"
  }

}
