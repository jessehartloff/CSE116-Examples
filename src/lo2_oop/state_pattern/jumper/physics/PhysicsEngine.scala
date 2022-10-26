package lo2_oop.state_pattern.jumper.physics

import lo2_oop.state_pattern.jumper.physics.objects._

/**
  * Controls and computes the simulated physics for a game. Manages dynamic object movement, gravity, and
  * object collisions
  */
object PhysicsEngine {


  // All objects are parallel to the axis

  def segmentsOverlap(lower1: Double, upper1: Double, lower2: Double, upper2: Double): Boolean = {
    lower2 < upper1 && upper2 > lower1
  }


  // Obj 1. Collision between physics.objects (rectangular cuboid)
  def isCollision(object1: GameObject, object2: GameObject): Boolean = {
    //    -Do these two rectangular cuboids overlap? (Welcome to the course and how HW rolls)
    //    —Given, the upper-left corner as a point, the height, and the width, depth
    //    -Each object knows it's location vector and dimensions (dimensions all go positive)
    val p1 = object1.location
    val p2 = object2.location

    val d1 = object1.dimensions
    val d2 = object2.dimensions

    segmentsOverlap(p1.x, p1.x + d1.x, p2.x, p2.x + d2.x) &&
      segmentsOverlap(p1.y, p1.y + d1.y, p2.y, p2.y + d2.y) &&
      segmentsOverlap(p1.z, p1.z + d1.z, p2.z, p2.z + d2.z)
  }


  // Obj 2. Update object velocity and potential location of an object
  def updateObject(dynamicObject: DynamicObject, deltaTime: Double, magnitudeOfGravity: Double): Unit = {

    dynamicObject.velocity.z -= magnitudeOfGravity * deltaTime

    dynamicObject.previousLocation.x = dynamicObject.location.x
    dynamicObject.previousLocation.y = dynamicObject.location.y
    dynamicObject.previousLocation.z = dynamicObject.location.z

    dynamicObject.location.x += deltaTime * dynamicObject.velocity.x
    dynamicObject.location.y += deltaTime * dynamicObject.velocity.y
    dynamicObject.location.z += deltaTime * dynamicObject.velocity.z

    if (dynamicObject.location.z <= 0.0) {
      dynamicObject.location.z = 0.0
      dynamicObject.velocity.z = 0.0
      dynamicObject.onGround()
    }

  }


  // Obj 3. Wall and platform collisions
  def checkStaticCollision(staticObject: StaticObject, dynamicObject: DynamicObject): Unit = {
    if (isCollision(staticObject, dynamicObject)) {
      dynamicObject.collideWithStaticObject(staticObject)
      if (isCollision(staticObject, new GameObject(dynamicObject.previousLocation, dynamicObject.dimensions))) {
        staticObject.collideWithDynamicObject(dynamicObject, Face.internal)
      } else {

        // External Collision
        val staticLocation = staticObject.location
        val previousLocation = dynamicObject.previousLocation

        val staticD = staticObject.dimensions
        val dynamicD = dynamicObject.dimensions

        val overlapX = segmentsOverlap(staticLocation.x, staticLocation.x + staticD.x, previousLocation.x, previousLocation.x + dynamicD.x)
        val overlapY = segmentsOverlap(staticLocation.y, staticLocation.y + staticD.y, previousLocation.y, previousLocation.y + dynamicD.y)
        val overlapZ = segmentsOverlap(staticLocation.z, staticLocation.z + staticD.z, previousLocation.z, previousLocation.z + dynamicD.z)

        var hits: Map[Int, Double] = Map()

        if (!overlapX) {
          val positiveMovement = dynamicObject.location.x - previousLocation.x > 0.0

          if (positiveMovement) {
            val time: Double = (staticLocation.x - (previousLocation.x + dynamicD.x)) / (dynamicObject.location.x - previousLocation.x)
            hits += (Face.negativeX -> time)
          }
          else {
            val time: Double = ((staticLocation.x + staticD.x) - previousLocation.x) / (dynamicObject.location.x - previousLocation.x)
            hits += (Face.positiveX -> time)
          }
        }

        if (!overlapY) {
          val positiveMovement = dynamicObject.location.y - previousLocation.y > 0.0

          if (positiveMovement) {
            val time: Double = (staticLocation.y - (previousLocation.y + dynamicD.y)) / (dynamicObject.location.y - previousLocation.y)
            hits += (Face.negativeY -> time)
          }
          else {
            val time: Double = ((staticLocation.y + staticD.y) - previousLocation.y) / (dynamicObject.location.y - previousLocation.y)
            hits += (Face.positiveY -> time)
          }
        }

        if (!overlapZ) {
          val positiveMovement = dynamicObject.location.z - previousLocation.z > 0.0

          if (positiveMovement) {
            val time: Double = (staticLocation.z - (previousLocation.z + dynamicD.z)) / (dynamicObject.location.z - previousLocation.z)
            hits += (Face.bottom -> time)
          }
          else {
            val time: Double = ((staticLocation.z + staticD.z) - previousLocation.z) / (dynamicObject.location.z - previousLocation.z)
            hits += (Face.top -> time)
          }
        }

        var maxTime = -1.0
        var maxFace = Face.internal

        for ((face, time) <- hits) {
          if (time > maxTime) {
            maxTime = time
            maxFace = face
          }
        }

        staticObject.collideWithDynamicObject(dynamicObject, maxFace)
      }

    }
  }


  // Primary Objective: Update world
  def updateWorld(world: World, deltaTime: Double): Unit = {

    for (obj: DynamicObject <- world.dynamicObjects) {
      this.updateObject(obj, deltaTime, world.gravity)
    }
    for (obj: DynamicObject <- world.dynamicObjects) {
      for (sObj: StaticObject <- world.staticObjects) {
        this.checkStaticCollision(sObj, obj)
      }

      // Bonus
      var foundThis: Boolean = false
      for (obj2: DynamicObject <- world.dynamicObjects) {
        if(foundThis){
          // remove dynamic collisions
//          checkDynamicCollision(obj, obj2)
        }
        if(obj2 == obj){
          foundThis = true
        }
      }
    }

  }


  def objectCenter(obj: GameObject): PhysicsVector = {
    new PhysicsVector(
      obj.dimensions.x / 2.0 + obj.location.x,
      obj.dimensions.y / 2.0 + obj.location.y,
      obj.dimensions.z / 2.0 + obj.location.z
    )
  }

  def dotProduct(v1: PhysicsVector, v2: PhysicsVector): Double = {
    v1.x * v2.x + v1.y * v2.y + v1.z * v2.z
  }

  def sumVectors(v1: PhysicsVector, v2: PhysicsVector): PhysicsVector = {
    new PhysicsVector(v1.x + v2.x, v1.y + v2.y, v1.z + v2.z)
  }

  def subtractVectors(v1: PhysicsVector, v2: PhysicsVector): PhysicsVector = {
    new PhysicsVector(v1.x - v2.x, v1.y - v2.y, v1.z - v2.z)
  }

  def scalarProduct(scalar: Double, v: PhysicsVector): PhysicsVector = {
    new PhysicsVector(scalar * v.x, scalar * v.y, scalar * v.z)
  }

  def magnitude(v: PhysicsVector): Double = {
    Math.sqrt(v.x * v.x + v.y * v.y + v.z * v.z)
  }

  def normalize(v: PhysicsVector): PhysicsVector = {
    val mag = magnitude(v)
    new PhysicsVector(v.x / mag, v.y / mag, v.z / mag)
  }


  def checkDynamicCollision(obj1: DynamicObject, obj2: DynamicObject): Unit = {
    if (isCollision(obj1, obj2)) {
      val center1 = objectCenter(obj1)
      val center2 = objectCenter(obj2)

      val collisionLine = normalize(new PhysicsVector(center1.x - center2.x, center1.y - center2.y, center1.z - center2.z))

      val scalarFactor1 = dotProduct(obj1.velocity, collisionLine)
      val scalarFactor2 = dotProduct(obj2.velocity, collisionLine)

      val ignored1 = subtractVectors(obj1.velocity, scalarProduct(scalarFactor1, collisionLine))
      val ignored2 = subtractVectors(obj2.velocity, scalarProduct(scalarFactor2, collisionLine))

      val m1 = obj1.mass
      val m2 = obj2.mass

      val v1f: Double = ((m1 - m2) / (m1 + m2)) * scalarFactor1 + ((2.0 * m2) / (m1 + m2)) * scalarFactor2
      val v2f: Double = ((2.0 * m1) / (m1 + m2)) * scalarFactor1 + ((m2 - m1) / (m1 + m2)) * scalarFactor2

      val delta1: PhysicsVector = scalarProduct(v1f, collisionLine)
      val delta2: PhysicsVector = scalarProduct(v2f, collisionLine)

      val o1Static = new StaticObject(obj1.location, obj1.dimensions)
      val o2Static = new StaticObject(obj2.location, obj2.dimensions)

      dynamicFaceCollision(obj1, obj2)
//      dynamicFaceCollision(obj2, obj1)

      obj1.velocity = sumVectors(delta1, ignored1)
      obj2.velocity = sumVectors(delta2, ignored2)
    }
  }


  def dynamicFaceCollision(dynamicObject: DynamicObject, fakeStaticObject: DynamicObject): Unit = {
    if (isCollision(dynamicObject, fakeStaticObject)) {
      if (isCollision(fakeStaticObject, new GameObject(dynamicObject.previousLocation, dynamicObject.dimensions))) {
        fakeStaticObject.collideWithDynamicObject(dynamicObject, Face.internal)
      } else {

        // External Collision
        val staticLocation = fakeStaticObject.location
        val previousLocation = dynamicObject.previousLocation

        val staticD = fakeStaticObject.dimensions
        val dynamicD = dynamicObject.dimensions

        val overlapX = segmentsOverlap(staticLocation.x, staticLocation.x + staticD.x, previousLocation.x, previousLocation.x + dynamicD.x)
        val overlapY = segmentsOverlap(staticLocation.y, staticLocation.y + staticD.y, previousLocation.y, previousLocation.y + dynamicD.y)
        val overlapZ = segmentsOverlap(staticLocation.z, staticLocation.z + staticD.z, previousLocation.z, previousLocation.z + dynamicD.z)

        var hits: Map[Int, Double] = Map()

        if (!overlapX) {
          val positiveMovement = dynamicObject.location.x - previousLocation.x > 0.0

          if (positiveMovement) {
            val time: Double = (staticLocation.x - (previousLocation.x + dynamicD.x)) / (dynamicObject.location.x - previousLocation.x)
            hits += (Face.negativeX -> time)
          }
          else {
            val time: Double = ((staticLocation.x + staticD.x) - previousLocation.x) / (dynamicObject.location.x - previousLocation.x)
            hits += (Face.positiveX -> time)
          }
        }

        if (!overlapY) {
          val positiveMovement = dynamicObject.location.y - previousLocation.y > 0.0

          if (positiveMovement) {
            val time: Double = (staticLocation.y - (previousLocation.y + dynamicD.y)) / (dynamicObject.location.y - previousLocation.y)
            hits += (Face.negativeY -> time)
          }
          else {
            val time: Double = ((staticLocation.y + staticD.y) - previousLocation.y) / (dynamicObject.location.y - previousLocation.y)
            hits += (Face.positiveY -> time)
          }
        }

        if (!overlapZ) {
          val positiveMovement = dynamicObject.location.z - previousLocation.z > 0.0

          if (positiveMovement) {
            val time: Double = (staticLocation.z - (previousLocation.z + dynamicD.z)) / (dynamicObject.location.z - previousLocation.z)
            hits += (Face.bottom -> time)
          }
          else {
            val time: Double = ((staticLocation.z + staticD.z) - previousLocation.z) / (dynamicObject.location.z - previousLocation.z)
            hits += (Face.top -> time)
          }
        }

        var maxTime = -1.0
        var maxFace = Face.internal

        for ((face, time) <- hits) {
          if (time > maxTime) {
            maxTime = time
            maxFace = face
          }
        }

        fakeStaticObject.collideWithDynamicObject(dynamicObject, maxFace)
      }

    }
  }


}
