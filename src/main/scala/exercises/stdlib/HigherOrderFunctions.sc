object HigherOrderFunctions {

  def addWithoutSyntaxSugar(x: Int) = {
    new Function1[Int, Int]() {
      def apply(y: Int): Int = x + y
    }
  }

  addWithoutSyntaxSugar(1)

  addWithoutSyntaxSugar(2)(3)


  def fiveAdder = addWithoutSyntaxSugar(5)
  fiveAdder(5)

//  isInstanceOf is the same as instanceof in java, but in this case the parameter types can be *blanked out* using existential types with a single underline, since parameter type are unknown at runtime.
  def addWithSyntaxSugar(x: Int) = (y: Int) ⇒ x + y
  addWithSyntaxSugar(1).isInstanceOf[Function1[_, _]]
}