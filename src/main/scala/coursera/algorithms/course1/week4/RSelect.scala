package coursera.algorithms.course1.week4

/**
  * Created by alexander on 5/20/17.
  */
object RSelect {

  def main(args: Array[String]): Unit = {

    val input: List[Int] = List(30, 80, 20, 50, 10, 40, 70, 60)
    val res = rSelect(input, 1)

    println(res)
  }

  def rSelect(input: List[Int], orderStatistics: Int): Int = {

    if(input.isEmpty) throw new IllegalAccessException("input is empty")
    if(input.length == 1) input.head
    else {
      val pivotIndex = 0
      val (left, pivot, right) =  partition(input, pivotIndex)
      val newPivotIndex = left.length
      if(pivotIndex > orderStatistics) rSelect(left, orderStatistics) else
      if(pivotIndex < orderStatistics) rSelect(right, orderStatistics - newPivotIndex) else
        pivot
    }

  }

  def partition(input: List[Int], pivotIndex: Int): (List[Int], Int, List[Int]) = {
    if (pivotIndex < 0 || pivotIndex >= input.length) throw new IllegalArgumentException("wrong pivotIndex" + pivotIndex)
    val pivot = input(pivotIndex)
    (input.filter(a => a < pivot), pivot, input.filter(a => a > pivot))
  }


}
