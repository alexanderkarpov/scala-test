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

  def msort(xs: List[Int]): List[Int] = {
    val n = xs.length / 2
    if(n == 0) xs
    else {
      def merge(xs: List[Int], ys: List[Int]): List[Int] = xs match {
        case Nil => ys
        case x :: xs1 => ys match {
          case Nil => xs
          case y :: ys1 =>
            if (x < y) x :: merge(xs1, ys)
            else y :: merge(xs, ys1)
        }
      }
      val (fst, snd) = xs splitAt n
      merge(msort(fst), msort(snd))
    }
  }


  println(msort(List(3,6,3,756,3444,73,23,64,710,3,0,1,-9,-53,-32,64)))

}
