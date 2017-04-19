package coursera.course3.week2

import coursera.course3.common._

/**
  * Created by alexander on 11/7/16.
  */
class MergeSort {

  val maxDepth: Int = ???
  val xs: Array[Int] = ???
  val ys: Array[Int] = ???

  def quickSort(arr: Array[Int], from: Int, until: Int) = ???

  def sort(from: Int, until: Int, depth: Int): Unit = {
    if (depth == maxDepth) {
      quickSort(xs, from, until - from)
    } else {
      val mid = (from + until) / 2
      parallel(sort(mid, until, depth + 1), sort(from, mid, depth + 1))

      val flip = (maxDepth - depth) % 2 == 0
      val src = if (flip) ys else xs
      val dst = if (flip) xs else ys

      merge(src, dst, from, mid, until)
    }
  }

  sort(0, xs.length, 0)

  def merge(src: Array[Int], dst: Array[Int], from: Int, mid: Int, until: Int): Unit = ???

  def copy(src: Array[Int], target: Array[Int], from: Int, until: Int, depth: Int): Unit = {
    if(depth == maxDepth) {
      Array.copy(src, from, target, from, until - from)
    } else {
      val mid = (from + until) / 2
      val right = parallel(
        copy(src, target, mid, until, depth + 1),
        copy(src, target, from, mid, depth + 1)
      )
    }
  }
  if(maxDepth % 2 == 0) copy(ys, xs, 0, xs.length, 0)

}
