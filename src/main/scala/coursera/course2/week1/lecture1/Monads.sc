/**
  * A monad M is a parametric type M[T] with two operations,
  * flatMap and unit, that have to satisfy three laws:
  * Associativity:
  *   m flatMap f flatMap g == m flatMap (x => f(x) flatMap g)
  * Left unit:
  *   unit(x) flatMap f == f(x)
  * Right unit:
  *   m flatMap unit == m
  *
  */
object Monads {

  trait M[T] {
    def flatMap[U](f: T => M[U]): M[U]
  }

  def unit[T](x: T): M[T] = ???
}