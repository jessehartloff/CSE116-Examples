package lo3_fp.concurrency.traffic

import akka.actor.ActorRef

case object ApproachingEastWest
case object ApproachingNorthSouth
case class Approaching(intersection: ActorRef, eastWest: Boolean)

case object CheckLight
case object ChangeLight
case object GreenLight

case class Direction(intersection: ActorRef, timeReachIntersection: Int, eastWest: Boolean)

case class Detour(detour: List[Direction])

case object GetNextDirection
case object ArrivedAtDestination
