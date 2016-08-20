package course1.week5.lecture5


object ReductionOfLists extends App {

  def sum(xs: List[Int]): Int = (0 :: xs) reduceLeft ((x, y) => x + y)

  def product(xs: List[Int]): Int = (1 :: xs) reduceLeft ((x, y) => x * y)

  val list = List(1, 2, 3, 4, 5)
  //  val list = List()

  println(sum(list))
  println(product(list))


}
