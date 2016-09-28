package mathan.lecture1

import org.scalacheck.Prop.forAll

object SetsCheck extends App {

  def intersection[T](a: Set[T], b: Set[T]) = a.filter(e => b.contains(e))

  def union[T](a: Set[T], b: Set[T]) = a ++ b

  def subtraction[T](a: Set[T], b: Set[T]) = a.filter(e => !b.contains(e))

  def mult[T](a: Set[T], b: Set[T]): Set[(T, T)] =
    for {
      x <- a
      y <- b
    } yield (x, y)

  def isSubset[T](a: Set[T], b: Set[T]): Boolean = a.forall(b.contains)

  def opt1[T](a: Set[T], b: Set[T], c: Set[T], d: Set[T]) = isSubset(
    intersection(
      subtraction(a, c),
      subtraction(b, d)),
    subtraction(
      intersection(a, c),
      intersection(b, d)
    )
  )

  def opt2[T](a: Set[T], b: Set[T], c: Set[T], d: Set[T]) = isSubset(
    subtraction(
      intersection(a, c),
      intersection(b, d)
    ),
    intersection(
      subtraction(a, c),
      subtraction(b, d))
  )

  def opt3[T](a: Set[T], b: Set[T], c: Set[T], d: Set[T]) = isSubset(
    union(
      subtraction(a, c),
      subtraction(b, d)),
    subtraction(
      union(a, c),
      union(b, d)
    )
  )

  def opt4[T](a: Set[T], b: Set[T], c: Set[T], d: Set[T]) = isSubset(
    subtraction(
      union(a, c),
      union(b, d)
    ),
    union(
      subtraction(a, c),
      subtraction(b, d))
  )

  def opt5[T](a: Set[T], b: Set[T], c: Set[T], d: Set[T]) = intersection(mult(a,c), mult(b,d)) ==
    mult(intersection(a,c), intersection(b,d))

  val propOpt = forAll { (a: Set[Int], b: Set[Int], c: Set[Int], d: Set[Int]) =>
    opt5(a, b, c, d)
  }
  propOpt.check

}
