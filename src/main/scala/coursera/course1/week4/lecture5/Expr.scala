package coursera.course1.week4.lecture5

/**
  * Created by alexander on 8/13/16.
  */
trait Expr {

  def eval: Int

}

class Number(n: Int) extends Expr {
  override def eval: Int = n
}

class Sum(e1: Expr, e2: Expr) extends Expr {
  override def eval: Int = e1.eval + e2.eval
}

object Test extends App {


  val s = new Sum(new Number(1), new Number(2)).eval

  println(s)

}