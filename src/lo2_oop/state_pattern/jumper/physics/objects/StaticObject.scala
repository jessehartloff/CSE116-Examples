package lo2_oop.state_pattern.jumper.physics.objects

import lo2_oop.state_pattern.jumper.physics.PhysicsVector

/**
  * This class represents a game object that cannot move (ex. walls and platforms).
  *
  * @param location The fixed location vector of the object
  * @param dimensions The size of the object
  */
class StaticObject(location: PhysicsVector, dimensions: PhysicsVector) extends GameObject(location, dimensions) {

}
