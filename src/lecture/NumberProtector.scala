package lecture

class NumberProtector(private var _number: Int) {

  // The value of _number is not directly assemble from outside this class. The following two
  // methods must be used to change _number

  /**
    * Decreases _number by 3
    */
  def reduceNumber():Unit = {
    _number -= 3
  }

  /**
    * Increases _number by 1
    * @return the value of number after incrementing it
    */
  def number: Int = {
    this._number += 1
    this._number
  }

}
