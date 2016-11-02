package coursera.course3.week1.lecture1

import java.lang.Math.{abs, ceil, pow}

object PNorm extends App{

  def sumSegment(a: Array[Int], p: Double, s: Int, t: Int): Int = {
    val list: List[Int] = (for (i <- (s until t)) yield a(i)).toList
    list.map(e => pow(abs(e), p)).map(e => ceil(e)).sum.toInt
  }

  def pNormTwoPart(a: Array[Int], p: Double): Int = {
    val m = a.length / 2
    val (sum1, sum2) = parallel (sumSegment(a, p, 0, m), sumSegment(a, p, m, a.length))
    ceil(pow(sum1 + sum2, 1 / p)).toInt
  }

  def power(x: Int, p: Double): Int = ceil(pow(x, p)).toInt

  def parallel(i: Int, i1: Int) : (Int, Int) = ???


  val arr: Array[Int] = Array(1,2,3,4)

  println(sumSegment(arr, 1.0, 0, arr.length))


}
