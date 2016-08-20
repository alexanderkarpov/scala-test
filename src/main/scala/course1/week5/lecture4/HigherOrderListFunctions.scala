package course1.week5.lecture4

object HigherOrderListFunctions extends App {

  def scaleList(xs: List[Double], factor: Double): List[Double] = xs match {
    case List() => xs
    case y :: ys => y * factor :: scaleList(ys, factor)
  }

  def squareList0(xs: List[Double]): List[Double] = xs match {
    case List() => xs
    case y :: ys => (y * y) :: squareList0(ys)
  }

  def squareList1(xs: List[Double]): List[Double] = xs map (x => x * x)

  def postElems0(xs: List[Int]): List[Int] = xs match {
    case Nil => xs
    case y :: ys => if (y > 0) y :: postElems0(ys) else postElems0(ys)
  }

  def postElems1(xs: List[Int]): List[Int] = xs.filter(x => x > 0)

  val num = List(3, 6, 3, 756, 3444, 73, 23, 64, 710, 3, 0, 1, -9, -53, -32, 64);
  val fruits = List("apple", "pineapple", "orange", "banana")

  println(num filter (x => x > 0))
  println(num filterNot (x => x > 0))
  println(num partition (x => x > 0))

  println(num takeWhile (x => x > 0))
  println(num dropWhile (x => x > 0))
  println(num span (x => x > 0))

  def pack[T](xs: List[T]): List[List[T]] = xs match {
    case Nil => Nil
    case y :: ys => {
      val (firstList, secondList) = xs.span(x => x.equals(y))
      firstList :: pack(secondList)
    }
  }

  val list = List('a','a','a','b','c','c','a')

  println(pack(list))

  def encode[T](xs: List[T]): List[(T, Int)] =   {
    pack(xs) map(list => (list.head, list.length))
  }

  println(encode(list))

}
