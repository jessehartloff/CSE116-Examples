package physics

import physics.objects.{DynamicObject, StaticObject}

/**
  * The World class stores of the static and dynamic object in a single game world
  *
  * @param gravity The magnitude of the gravitation force for this engine. As a magnitude, this value will always be
  *                positive and should be negated before use to apply it along the negative z axis
  */
class World(var gravity: Double) {

  var staticObjects: List[StaticObject] = List()
  var dynamicObjects: List[DynamicObject] = List()

}
