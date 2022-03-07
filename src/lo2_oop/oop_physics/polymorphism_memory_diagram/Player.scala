package lo2_oop.oop_physics.polymorphism_memory_diagram

class Player() {
  var inventory: List[GameObject] = List()
  def pickUp(obj: GameObject): Unit = {
    this.inventory = obj :: this.inventory
  }
  def totalWeight(): Double = {
    var total: Double = 0.0
    for(obj <- this.inventory){
      total += obj.weight()
    }
    total
  }
}

