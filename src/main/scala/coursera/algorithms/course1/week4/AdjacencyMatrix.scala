package coursera.algorithms.course1.week4

/**
  * Created by alexander on 5/28/17.
  */
class AdjacencyMatrix(rows: List[List[Int]]) {

  if (rows.nonEmpty) {
    val n = rows.head.length
    if (rows.map(_.length).count(length => length == n) != n)
      throw new IllegalArgumentException("rows with different lengths are not allowed")
  }

  type Row = List[Int]

  override def toString: String = {
    val placeHolderSize = 5
    def rowToString(row: Row): String = row.map(i => s"%${placeHolderSize}d".format(i)).mkString(",")
    rows.map(rowToString).mkString("\n")
  }
}
