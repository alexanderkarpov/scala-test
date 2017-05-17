package coursera.algorithms.course1.week2

import scala.io.Source

/**
  * Created by alexander on 4/19/17.
  */
object CountingInversion {

  def main(args: Array[String]): Unit = {

    val fileName = "/home/alexander/GIT/scala-test/src/main/resources/algorithms/integerArray.txt"

    val input: List[Int] = Source.fromFile(fileName).getLines().map(s => Integer.parseInt(s)).toList
    println(s"total items: ${input.length}")
    println(sortedCount(input)._2)
//    println(mergeSort(input))
  }

  def mergeSort(input: List[Int]): List[Int] = {
    val (half1, half2) = input.splitAt(input.length / 2)
    println(half1.length + " - " + half2.length)
    if (half1.length <= 1 && half2.length <= 1) merge(half1, half2)
    else merge(mergeSort(half1), mergeSort(half2))
  }

  def merge(a: List[Int], b: List[Int]): List[Int] = {
    def loop(x: List[Int], y: List[Int], acc: List[Int]): List[Int] = (x, y) match {
      case (Nil, _) => acc ::: y
      case (_, Nil) => acc ::: x
      case (xh :: xt, yh :: yt) if xh < yh => loop(xt, yh :: yt, acc ::: List(xh))
      case (xx, yh :: yt) => loop(xx, yt, acc ::: List(yh))
    }

    return loop(a, b, List.empty)
  }

  def sortedCount(a: List[Int]): (List[Int], Long) = {
    if (a.length <= 1) {
      println(a)
      (a, 0)
    }
    else {
//      println(a.length)
      val (half1, half2) = a.splitAt(a.length / 2)
      val (b, x) = sortedCount(half1)
      val (c, y) = sortedCount(half2)
      val (d, z) = mergeAndCountSplitInv(b, c)

      (d, x + y + z)
    }
  }

  def mergeAndCountSplitInv(a: List[Int], b: List[Int]): (List[Int], Long) = {

    def loop(x: List[Int], y: List[Int], acc: List[Int], count: Long): (List[Int], Long) = (x, y) match {
      case (Nil, _) => (acc ::: y, count)
      case (_, Nil) => (acc ::: x, count)
      case (xh :: xt, yh :: yt) if xh < yh => loop(xt, yh :: yt, acc ::: List(xh), count)
      case (xx, yh :: yt) => loop(xx, yt, acc ::: List(yh), count + xx.length)
    }

    loop(a, b, List.empty, 0L)
  }

}
