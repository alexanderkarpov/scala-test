package coursera.course1.week5.lecture5


object ReductionOfLists extends App {

  //  def sum(xs: List[Int]): Int = (0 :: xs) reduceLeft (_ + _) // ((x, y) => x + y)
  def sum(xs: List[Int]): Int = xs.foldLeft(0)(_ + _) // ((x, y) => x + y)

  //  def product(xs: List[Int]): Int = (1 :: xs) reduceLeft (_ * _) // ((x, y) => x * y)
  def product(xs: List[Int]): Int = (xs foldLeft 1) (_ * _)

  val list = List(1, 2, 3, 4, 5)
  //  val list = List()

  println(sum(list))
  println(product(list))

  def mapFun[T, U](xs: List[T], f: T => U): List[U] =
    (xs foldRight List[U]()) ((x, y) => List(f.apply(x)) ::: y)

  def lengthFun[T](xs: List[T]): Int =
    (xs foldRight 0) ((x, y) => y + 1)

  println(lengthFun(list))
  println(mapFun[Int, Double](list, x => x / 2.0))

}
