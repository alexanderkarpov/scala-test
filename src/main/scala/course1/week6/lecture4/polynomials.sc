object polynomials {

  class Poly(val terms0: Map[Int, Double]) {
    def this(bindings: (Int, Double) *) = this(bindings.toMap)
    val terms = terms0 withDefaultValue 0.0
    //TODO: refactor with the foldLeft
    def + (other: Poly) = new Poly(terms ++ (other.terms map adjust))
    def adjust(term: (Int, Double)): (Int, Double) = {
      val (exp, coeff) = term
      exp -> (coeff + terms(exp))
//      terms.get(exp)  match {
//        case Some(coeff1) => exp -> (coeff + coeff1)
//        case None => exp -> coeff
//
//      }
    }

    override def toString: String =
      (for((exp, coeff) <- terms.toList.sorted.reverse) yield (coeff + "X^" + exp)).mkString(" + ")
  }

  val p1 = new Poly(1 -> 2.0, 3 -> 4.0, 5 -> 6.2)
  val p2 = new Poly(Map(0 -> 3.0, 3 -> 7.0))

  p1 + p2

}