package course1.week5.lecture2

/**
  * Merge Sort
  *
  * if the list consists of zero or no elements, it is already sorted
  * Otherwise:
  *   - separate the list into two sub-lists, each containing around half of the elements of the original list
  *   - sort the two sub-lists
  *   - merge the two sorted sub-lists into a single sorted list
  *
  */
object MergeSort extends App {

  def msort[T](xs: List[T])(lt: (T, T) => Boolean): List[T] = {
    val n = xs.length / 2
    if (n == 0) xs
    else {

      def merge(xs: List[T], ys: List[T]): List[T] = (xs, ys) match {
        case (Nil, ys) => ys
        case (xs, Nil) => xs
        case (x :: xs1, y :: ys1) => if (lt(x, y)) x :: merge(xs1, ys) else y :: merge(ys1, xs)
      }

      val (fst, snd) = xs splitAt n
      merge(msort(fst)(lt), msort(snd)(lt))
    }
  }

  //  def readyToSort = msort(List(3, 6, 3, 756, 3444, 73, 23, 64, 710, 3, 0, 1, -9, -53, -32, 64));

  println(msort(List(3, 6, 3, 756, 3444, 73, 23, 64, 710, 3, 0, 1, -9, -53, -32, 64))((x, y) => x < y))

}
