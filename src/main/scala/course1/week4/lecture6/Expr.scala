package course1.week4.lecture6

/**
  * Created by alexander on 8/13/16.
  */
trait Expr {

  def eval(e: Expr): Int = e match {
    case Number(n) => n
    case Sum(e1, e2) => eval(e1) + eval(e2)
    case Prod(e1, e2) => eval(e1) * eval(e2)
  }

  def show(e: Expr): String = e match {
    case Number(n) => n.toString
    case Sum(e1, e2) => show(e1) + " + " + show(e2)
    case Prod(e1, e2) => show(e1) + " * " + show(e2)
  }

}

case class Number(n: Int) extends Expr

case class Sum(e1: Expr, e2: Expr) extends Expr

case class Prod(e1: Expr, e2: Expr) extends Expr

object Test extends App {

  val e0: Expr = new Sum(new Number(2), new Prod(new Number(2), new Number(2)))
  println(e0.show(e0) + " = " + e0.eval(e0))
}


