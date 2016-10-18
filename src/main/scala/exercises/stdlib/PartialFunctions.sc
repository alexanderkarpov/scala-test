object PartialFunctions {

  /*
  A partial function is a trait that when implemented can be used as building
  blocks to determine a solution. The trait PartialFunction requires that the method isDefinedAt and apply be implemented.
   */
  val doubleEvens: PartialFunction[Int, Int] = new PartialFunction[Int, Int] {

    //States that this partial function will take on the task
    override def isDefinedAt(x: Int): Boolean = x % 2 == 0

    //What we do if this partial function matches
    override def apply(v1: Int): Int = v1 * 2
  }

}