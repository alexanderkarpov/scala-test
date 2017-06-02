package coursera.algorithms.course1.week4

/**
  * Created by alexander on 5/28/17.
  */
object RandomContraction {

  def main(args: Array[String]): Unit = {

    val rows: List[List[Int]] = List(List(0, 1, 0), List(1, 2, 0), List(0, 3, 1))

    val matrix: AdjacencyMatrix = new AdjacencyMatrix(rows)

    println(matrix)


  }

}
