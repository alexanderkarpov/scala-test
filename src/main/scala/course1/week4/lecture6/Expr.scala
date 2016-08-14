package course1.week4.lecture6

/**
  * Created by alexander on 8/13/16.
  */
trait Expr {

  def eval(e: Expr): Int = e match {
    case Number(n) => n
    case Sum(e1, e2) => eval(e1) + eval(e2)
  }

}

case class Number(n: Int) extends Expr

case class Sum(e1: Expr, e2: Expr) extends Expr

