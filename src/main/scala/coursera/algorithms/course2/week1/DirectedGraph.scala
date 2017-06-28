package coursera.algorithms.course2.week1

import scala.collection.mutable

class DirectedGraph(map: Map[Int, List[Int]]) {

  def depthFirstSearch(startVertex: Int): List[Int] = {
    if(!map.contains(startVertex)) throw new IllegalArgumentException("start vertex doesn't exist")

    val explored: mutable.Set[Int] = new mutable.HashSet[Int]()

    def loop(vertex: Int, acc: List[Int]): List[Int] = {

      if(explored.contains(vertex)) acc
      else {
        explored.add(vertex)
        val edges: Option[List[Int]] = map.get(vertex)
        if(edges.nonEmpty) {
          vertex :: edges.get.flatMap(v => loop(v, acc))
        } else {
          vertex :: acc
        }
      }
    }

    loop(startVertex, Nil)
  }

}

