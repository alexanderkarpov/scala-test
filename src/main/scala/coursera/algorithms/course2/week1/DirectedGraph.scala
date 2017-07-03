package coursera.algorithms.course2.week1

import scala.collection.mutable
import scala.io.Source

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

object DirectedGraph {

  def main(args: Array[String]): Unit = {
    val srcFileName = "src/main/resources/algorithms/scc.txt"
    val graph = DirectedGraph.fromFile(srcFileName)
    println(graph.vertices.size)
  }

  def fromFile(path: String): DirectedGraph = {
    println(s"loading data from $path ...")
    val t0 = System.currentTimeMillis
    val vertices: Map[Int, List[Int]] =
      Source.fromFile(path).getLines
        .toList
        .map(_.split(" "))
        .map(items => (items(0), items(1)))
        .map(p => (Integer.parseInt(p._1), Integer.parseInt(p._2)))
        .groupBy(_._1)
        .map(e => (e._1, e._2.map(_._2)))

    val t1 = System.currentTimeMillis
    println(s"data loaded from file in ${(t1 - t0) / 1000} sec")
    val graph = DirectedGraph(vertices)
    val t2 = System.currentTimeMillis
    println(s"graph created in ${(t2 - t1) / 1000} sec")
    graph
  }

}

