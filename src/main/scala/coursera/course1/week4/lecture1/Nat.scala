package coursera.course1.week4.lecture1

/**
  * Peano numbers
  * Created by alexander on 8/9/16.
  */
abstract class Nat {

  def isZero: Boolean

  /**
    *
    * @return prev natural number or throw the Exception if the current nmb is 0
    */
  def predecessor: Nat

  /**
    *
    * @return next natural number
    */
  def successor: Nat = new Succ(this)

  def +(that: Nat): Nat

  /**
    * throws the exception if the result is negative
    *
    * @param that
    * @return
    */
  def -(that: Nat): Nat

}

object Zero extends Nat {

  override def isZero: Boolean = true

  override def predecessor: Nat = throw new NoSuchElementException

  override def +(that: Nat): Nat = that

  override def -(that: Nat): Nat = if (that.isZero) this else throw new NoSuchElementException
}

/**
  * represents the number that the one bigger than the number in argument
  *
  * @param n
  */
class Succ(n: Nat) extends Nat {

  override def isZero: Boolean = false

  override def predecessor: Nat = n

  override def +(that: Nat): Nat = new Succ(n + that) //n + that

  override def -(that: Nat): Nat = if (that.isZero) this else n - predecessor
}
