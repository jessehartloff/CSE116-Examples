package physics.objects

import physics.PhysicsVector

/**
  * This class represents a game object that does not have a fixed position. As such, these objects have a velocity
  * to determine their movement, and mass to determine their momentum. The physics engine will move these objects
  * during each update.
  *
  * @param location Initial location vector of the object
  * @param dimensions The size of the object
  */
class DynamicObject(location: PhysicsVector, dimensions: PhysicsVector) extends GameObject(location, dimensions) {

  var velocity: PhysicsVector = new PhysicsVector()

  var mass: Double = 5.0

  /**
    * onGroundCalled has no real functionality, but will be used while testing the physics engine. When testing
    * for collisions with the ground, use this variable to check if the onGround method was called
    */
  var onGroundCalled: Boolean = false

  /**
    * Like onGroundCalled, the following variables have no real functionality, but will be used while
    * testing objective 3 of the physics engine. When testing for collisions with static objects, use
    * these variables to check if the collideWithStaticObject method was properly called
    */
  var collideWithStaticObjectCalled: Boolean = false
  var staticObject: StaticObject = _

  /**
    * previousLocation is used by the physics engine and other objects to determine the movement vector of the
    * dynamic object during a particular update. This value is computed at the beginning of each update and
    * represents the location of the object before the object location was updated.
    *
    * Example Use: If an object collides with a wall its location can be set back to its previous location to "undo"
    * the movement
    */
  var previousLocation = new PhysicsVector()


  /**
    * Called by the physics engine whenever the object is on the ground. By default, an object does nothing when
    * on the ground. Extending classes will add functionality to this method as needed.
    *
    * Example: We will create a player class that can only jump when it's on the ground. When this method is called
    * by the physics engine we can enable the jump button
    */
  def onGround(): Unit = {
    this.onGroundCalled = true
  }


  /**
    * Called by the physics engine whenever the object collides with a static object. By default, an object does not
    * react to such a collision. Extending classes will add functionality to this method as needed.
    *
    * @param staticObject The static object with which the object collided
    */
  def collideWithStaticObject(staticObject: StaticObject): Unit = {
    this.collideWithStaticObjectCalled = true
    this.staticObject = staticObject
  }

}
