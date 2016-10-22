package exercises.stdlib

import java.math.BigInteger

object ImplicitsTest extends App {

  implicit def Int2BigIntegerConvert(value: Int): BigInteger = new BigInteger(value.toString)

  def add(a: BigInteger, b: BigInteger) = a.add(b)

  val res0 = add(Int2BigIntegerConvert(3), Int2BigIntegerConvert(6))
  val res1 = Int2BigIntegerConvert(9)

  println(res0)
  println(res1)

  println(add(3, 6))

  println(add(3, 6) == 9)
  println(add(3, 6) == Int2BigIntegerConvert(9))


}
