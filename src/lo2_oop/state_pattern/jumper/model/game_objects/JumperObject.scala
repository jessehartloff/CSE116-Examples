package lo2_oop.state_pattern.jumper.model.game_objects

import lo2_oop.state_pattern.jumper.physics.PhysicsVector
import lo2_oop.state_pattern.jumper.physics.objects.StaticObject


object JumperObject{
  var nextID: Int = 0
}

class JumperObject(location: PhysicsVector, dimensions: PhysicsVector) extends StaticObject(location, dimensions){
  val objectID: Int = JumperObject.nextID
  JumperObject.nextID += 1
}
