package coursera.algorithms.course1.week2

/**
  * Created by alexander on 4/19/17.
  */
object CountingInversion {

  def main(args: Array[String]): Unit = {

    println(merge(List(1, 3, 5, 7, 9, 14, 15, 16, 17, 18, 19, 20, 21), List(2, 4, 6, 8, 10, 11, 12, 13, 14)))

    val list = List(1)

    println(list.splitAt(list.length / 2))

    println(mergeSort(List(9, 3, 5, 6, 8, 1, 4, 2, 7)))
    println(sortedCount(List(1, 3, 5, 2, 4, 6)))

  }

  def mergeSort(input: List[Int]): List[Int] = {
    val (half1, half2) = input.splitAt(input.length / 2)
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

  def sortedCount(a: List[Int]): (List[Int], Int) = {
    if (a.length == 1) (a, 0)
    else {
      val (half1, half2) = a.splitAt(a.length / 2)
      val (b, x) = sortedCount(half1)
      val (c, y) = sortedCount(half2)
      val (d, z) = mergeAndCountSplitInv(b, c)

      (d, x + y + z)
    }
  }

  def mergeAndCountSplitInv(a: List[Int], b: List[Int]): (List[Int], Int) = {

    def loop(x: List[Int], y: List[Int], acc: List[Int], count: Int): (List[Int], Int) = (x, y) match {
      case (Nil, _) => (acc ::: y, count)
      case (_, Nil) => (acc ::: x, count)
      case (xh :: xt, yh :: yt) if xh < yh => loop(xt, yh :: yt, acc ::: List(xh), count)
      case (xx, yh :: yt) => loop(xx, yt, acc ::: List(yh), count + xx.length)
    }

    loop(a, b, List.empty, 0)
  }

}
