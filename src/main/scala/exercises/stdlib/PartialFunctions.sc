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

  val tripleOdds: PartialFunction[Int, Int] = new PartialFunction[Int, Int] {
    def isDefinedAt(x: Int) = x % 2 != 0

    def apply(v1: Int) = v1 * 3
  }


  val whatToDo = doubleEvens orElse tripleOdds //Here we chain the partial functions together

  whatToDo(5)
  doubleEvens.applyOrElse(50, (x: Int) => x)


  //Case statements are a quick way to create partial functions. When you create a case statement,
  // the apply and isDefinedAt is created for you.
  val doubleEvens2: PartialFunction[Int, Int] = {
    case x if (x % 2) == 0 ⇒ x * 2
  }
  val tripleOdds2: PartialFunction[Int, Int] = {
    case x if (x % 2) != 0 ⇒ x * 3
  }

  val whatToDo2 = doubleEvens2 orElse tripleOdds2 //Here we chain the partial functions together

  whatToDo2(20)

  val addFive = (x: Int) ⇒ x + 5
  val whatToDo3 = doubleEvens orElse tripleOdds andThen addFive //Here we chain the partial functions together

  whatToDo3(5)

  val whatToDo4 = doubleEvens2 andThen ((x: Int) => x + 1)
  whatToDo4(4)
  whatToDo4(5)

}