object Currying {

  def multiply(x: Int, y: Int) = x * y
  (multiply _).isInstanceOf[Function2[_, _, _]]
  val multiplyCurried = (multiply _).curried

  multiplyCurried(3)(2)


  def customFilter(f: Int ⇒ Boolean)(xs: List[Int]): List[Double] = {
    (xs filter f).map(a => a + 0.0)
  }
  def onlyEven(x: Int) = x % 2 == 0
  val xs = List(12, 11, 5, 20, 3, 13, 2)
  customFilter(onlyEven)(xs)

  val onlyEvenFilter = customFilter(onlyEven) _

  onlyEvenFilter(List(1,2,3,4,5,6,7,8))
}