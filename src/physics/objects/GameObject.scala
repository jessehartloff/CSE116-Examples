package physics.objects

import physics.PhysicsVector

/***
  * A object in the game which is represented by a Rectangular Cuboid.
  *
  * All objects are parallel to the game's axis system (ie. objects cannot rotate). The location vector is the location
  * of the corner with the smallest value in all three dimensions (think lower-left corner in a typical 2d axis). The
  * dimension vector represents the height, width, and depth of the object.
  *
  * Example: And object with values
  * location = (3, -10, 0)
  * dimensions = (1, 5, 4)
  * Will occupy the area from (3, -10, 0) to (4, -5, 4)
  *
  * @param location Initial location vector of the object
  * @param dimensions The size of the object
  */
class GameObject(var location: PhysicsVector, var dimensions: PhysicsVector) {

  /**
    * Much like the testing variables in the DynamicObject class, the following three variables have no real
    * functionality, but will be used while testing objective 3 of the physics engine. When testing
    * for collisions with dynamic objects, use these variables to check if the collideWithDynamicObject
    * method was properly called
    */
  var collideWithDynamicObjectCalled: Boolean = false
  var otherObject: DynamicObject = _
  var face: Integer = -1


  /**
    * If an object is destroyed it should be removed from the game world.
    *
    * Example: A projectile that hits a target should be destroyed and removed from the game
    *
    * Note: This functionality will not be used in the physics engine assignment
    */
  var destroyed: Boolean = false

  def destroy(): Unit = {
    destroyed = true
  }

  /**
    * Called by the physics engine whenever the object collides with a dynamic object. By default, an object does not
    * react to such a collision. Extending classes will add functionality to this method as needed.
    *
    * @param otherObject The dynamic object with which the object collided
    * @param face Indicates with which face of the object collided
    */
  def collideWithDynamicObject(otherObject: DynamicObject, face: Integer): Unit = {
    this.collideWithDynamicObjectCalled = true
    this.otherObject = otherObject
    this.face = face
  }


  override def toString = {
    "Location: " + this.location + " | dimensions: " + this.dimensions
  }

}
