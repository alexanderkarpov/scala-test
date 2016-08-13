package course1.week4.lecture5

/**
  * Created by alexander on 8/13/16.
  */
trait Expr {

  def isNumber: Boolean
  def isSum: Boolean
  def numValue: Int
  def leftOp: Expr
  def rightOp: Expr

}

class Number(n: Int) extends Expr {
  override def isNumber: Boolean = true

  override def isSum: Boolean = false

  override def numValue: Int = n

  override def leftOp: Expr = throw new Error("number.leftOp")

  override def rightOp: Expr = throw new Error("number.rightOp")
}

class Sum(e1: Expr, e2: Expr) extends Expr {
  override def isNumber: Boolean = false

  override def isSum: Boolean = true

  override def numValue: Int = throw new Error("sum.numValue")

  override def leftOp: Expr = e1

  override def rightOp: Expr = e2
}

object Test extends App {

  def eval(e: Expr): Int = {
    if(e.isNumber) e.numValue
    else if (e.isSum) eval(e.leftOp) + eval(e.rightOp)
    else throw new UnsupportedOperationException("unknown operation")
  }

}