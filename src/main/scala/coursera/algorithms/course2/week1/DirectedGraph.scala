package coursera.algorithms.course2.week1

import scala.collection.mutable

case class DirectedGraph(vertices: Map[Int, List[Int]]) {

  lazy val reverse: DirectedGraph = {

    val reversedVertices =
      vertices
        .toList
        .flatMap(e => e._2.map(v => (v, e._1)))
        .groupBy(_._1)
        .map(e => (e._1, e._2.map(_._2)))

    DirectedGraph(reversedVertices)
  }

  def depthFirstSearch(startVertex: Int): List[Int] = {
    if (!vertices.contains(startVertex)) throw new IllegalArgumentException("start vertex doesn't exist")

    val explored: mutable.Set[Int] = new mutable.HashSet[Int]()

    def loop(vertex: Int, acc: List[Int]): List[Int] = {

      if (explored.contains(vertex)) acc
      else {
        explored.add(vertex)
        val edges: Option[List[Int]] = vertices.get(vertex)
        if (edges.nonEmpty) {
          vertex :: edges.get.flatMap(v => loop(v, acc))
        } else {
          vertex :: acc
        }
      }
    }

    loop(startVertex, Nil)
  }

}

