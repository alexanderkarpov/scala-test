package course1.week4.idealized.scala

/**
  * Created by alexander on 8/9/16.
  */
abstract class Nat {

  def isZero: scala.Boolean

  /**
    *
    * @return prev natural number or throw the Exception if the current nmb is 0
    */
  def predecessor: Nat

  /**
    *
    * @return next natural number
    */
  def successor: Nat

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
  override def isZero: Boolean = ???

  /**
    *
    * @return prev natural number or throw the Exception if the current nmb is 0
    */
  override def predecessor: Nat = ???

  /**
    *
    * @return next natural number
    */
  override def successor: Nat = ???

  override def +(that: Nat): Nat = ???

  /**
    * throws the exception if the result is negative
    *
    * @param that
    * @return
    */
  override def -(that: Nat): Nat = ???
}

class Succ(n: Nat) extends Nat {
  override def isZero: Boolean = ???

  /**
    *
    * @return prev natural number or throw the Exception if the current nmb is 0
    */
  override def predecessor: Nat = ???

  /**
    *
    * @return next natural number
    */
  override def successor: Nat = ???

  override def +(that: Nat): Nat = ???

  /**
    * throws the exception if the result is negative
    *
    * @param that
    * @return
    */
  override def -(that: Nat): Nat = ???
}
