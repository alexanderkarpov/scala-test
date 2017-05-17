package coursera.algorithms.course1.week3

/**
  * Created by alexander on 5/17/17.
  */
object QuickSort {

  def main(args: Array[String]): Unit = {
    println("preved")
    val list: List[Int] = List(3, 8, 2, 5, 1, 4, 7, 6)

    println(quickSort(list))

  }

  def quickSort(input: List[Int]): List[Int] = {

    if (input.length <= 1) {
      input
    } else {
      val pivot = choosePivot(input)
      val (left, right) = partition(input, pivot)
      quickSort(left) ::: List(pivot) ::: quickSort(right)
    }
  }

  def choosePivot(input: List[Int]): Int = input.head

  def partition(input: List[Int], pivot: Int): (List[Int], List[Int]) =
    (input.filter(a => a < pivot), input.filter(a => a > pivot))


}
