package coursera.course2.week3.assignment.quickcheck

import org.scalacheck.Prop.{BooleanOperators, forAll}
import org.scalacheck.{Gen, Prop, Properties}

object ScalaCheckTest extends App {

  //https://github.com/rickynils/scalacheck/blob/master/doc/UserGuide.md

  //

  //  Universally quantified properties

  val propConcatLists = forAll { (l1: List[Int], l2: List[Int]) =>
    l1.size + l2.size == (l1 ::: l2).size
  }


  propConcatLists.check


  val propSqrt = forAll { (n: Int) => scala.math.sqrt(n * n) == n }
  //  propSqrt.check


  val smallInteger = Gen.choose(0, 200)

  val propSmallInteger = Prop.forAll(smallInteger) { n =>
    n >= 0 && n <= 200
  }

  propSmallInteger.check

  // Conditional Properties
  var list: List[String] =
  List.fill(5)("a")

  List.tabulate(5, 5)((a, b) => (a * 2, b * 3))

  val propMakeList = forAll { n: Int =>
    (n >= 0 && n < 10000) ==> (List.fill(n)("").length == n)
  }
  propMakeList.check

  val propTrivial = forAll { n: Int =>
    (n == 0) ==> (n == 0)
  }

  propTrivial.check

  def bernoulliInequality(n: Int, x: Double): Boolean =
    if (n < 0) throw new IllegalArgumentException("wrong n: " + n)
    else Math.pow(1 + x, n) >= 1 + n * x

  val propBernoulliInequality = forAll { (n: Int, x: Double) =>
    (n >= 0 && n <= 10000000 && x < Math.abs(10000)) ==> bernoulliInequality(n, x)
  }
  propBernoulliInequality.check

  val prop100500 = forAll{
    n: Int => n != 100500
  }
  prop100500.check

  val p1 = propSmallInteger || propSqrt

  p1.check
  println("------------")


}
