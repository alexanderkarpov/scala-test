package course1.week4.idealized.scala

/**
  * Created by alexander on 8/9/16.
  */
abstract class Boolean {

  def ifThenElse[T](t: => T, e: => T): T

  def &&(x: => Boolean): Boolean = ifThenElse(x, False)

  def ||(x: => Boolean): Boolean = ifThenElse(True, x)

  def unary_! : Boolean = ifThenElse(False, True)

  def ==(x: Boolean): Boolean = ifThenElse(x, x.unary_!)

  def !=(x: Boolean): Boolean = ifThenElse(x.unary_!, x)

  def < (x: => Boolean): Boolean = ???


}

object True extends Boolean {
  override def ifThenElse[T](t: => T, e: => T): T = t

  override def toString = "True"
}

object False extends Boolean {
  override def ifThenElse[T](t: => T, e: => T): T = e

  override def toString = "False"
}

object Main extends App {
  println(True && True)
}