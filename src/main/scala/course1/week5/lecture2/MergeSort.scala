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

  /*
  Say, a function takes an implicit parameter of a type T
  Compiler will search an implicit definition that
    - is marked implicit
    - has type compatible with T
    - is visible at the point of the function call,
      or is defined as a companion object associated with T

  If there is a single (most specific) definition, it will be taken as
  actual argument for the implicit parameter

  Otherwise it's an error
   */
  def msort[T](xs: List[T])(implicit ord: Ordering[T]): List[T] = {
    val n = xs.length / 2
    if (n == 0) xs
    else {

      def merge(xs: List[T], ys: List[T]): List[T] = (xs, ys) match {
        case (Nil, ys) => ys
        case (xs, Nil) => xs
        case (x :: xs1, y :: ys1) => if (ord.lt(x, y)) x :: merge(xs1, ys) else y :: merge(ys1, xs)
      }

      val (fst, snd) = xs splitAt n
      merge(msort(fst), msort(snd))
    }
  }

  val num = List(3, 6, 3, 756, 3444, 73, 23, 64, 710, 3, 0, 1, -9, -53, -32, 64);
  val fruits = List("apple", "pineapple", "orange", "banana")

  println(msort(num))
  println(msort(fruits))

}
