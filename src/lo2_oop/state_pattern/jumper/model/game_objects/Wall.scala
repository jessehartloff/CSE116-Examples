package lo2_oop.state_pattern.jumper.model.game_objects

import lo2_oop.state_pattern.jumper.physics.PhysicsVector
import lo2_oop.state_pattern.jumper.physics.objects.{DynamicObject, Face}


class Wall(location: PhysicsVector, dimensions: PhysicsVector) extends JumperObject(location, dimensions){

  override def collideWithDynamicObject(otherObject: DynamicObject, face: Integer): Unit = {
    if(face == Face.negativeX){
      otherObject.velocity.x = 0.0
      otherObject.location.x = this.location.x - otherObject.dimensions.x
    }else if(face == Face.positiveX){
      otherObject.velocity.x = 0.0
      otherObject.location.x = this.location.x + this.dimensions.x
    }
  }

}
