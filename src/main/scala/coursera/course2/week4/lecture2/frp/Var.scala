package coursera.course2.week4.lecture2.frp

class Var[T](expr: => T) extends Signal[T](expr) {
  override protected def update(expr: => T): Unit = super.update(expr)
}

object Var {
  def apply[T](expr: => T) = new Var(expr)
}
