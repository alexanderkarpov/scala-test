package coursera.algorithms.course2.week1

import java.util.Date

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

  lazy val verticesValues: List[Int] =
    vertices.flatMap(e => e._1 :: e._2).toList.distinct.sorted(Ordering[Int].reverse)

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

  def kasaraju(g: DirectedGraph) = {
    val magicalOrdering = dfsLoop(g.reverse)

  }


  def dfsLoop(g: DirectedGraph): (List[Int], List[List[Int]]) = { // (finishingTimes, sccs)
    val t = new Counter
    val f = new Array[Int](g.verticesValues.size)
    val explored = new mutable.HashSet[Int]


    val sccs = new mutable.MutableList[List[Int]]
    g.verticesValues.foreach(i => if (!explored.contains(i)) {
      dfs(g, i, f, explored, t).foreach(sccs += _)
    })



    println(s"SCCs: $sccs")

    (f.toList, sccs.toList)
  }

  def dfs(g: DirectedGraph, i: Int, f: Array[Int], explored: mutable.Set[Int], t: Counter): List[List[Int]] = {

    val currentScc: mutable.MutableList[Int] = new mutable.MutableList[Int]()
    val acc: mutable.MutableList[List[Int]] = new mutable.MutableList[List[Int]]()

    def loop(g: DirectedGraph, i: Int): Unit = {
      explored.add(i)
      currentScc += i
      //TODO: set leader(i) := nodes ????
      val notExplored = g.vertices.getOrElse(i, Nil).filter(!explored.contains(_))
      if(notExplored.isEmpty) {
        acc += currentScc.toList
        currentScc.clear
      }
      notExplored.foreach(loop(g, _))


      t.increment
      f.update(i - 1, t.value)
    }

    loop(g, i)
    acc.toList
  }

  def main(args: Array[String]): Unit = {
    val srcFileName = "src/main/resources/algorithms/scc.txt"
    val graph = DirectedGraph.fromFile(srcFileName)
    println(s"${graph.vertices.size} - ${new Date}")

    println(s"${graph.verticesValues.size} - ${graph.verticesValues.head}")
    val res = dfsLoop(graph)
    println(s"${res._1.length} - ${new Date}")
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

class Counter {
  var value: Int = 0

  def increment: Int = {
    value = value + 1
    value
  }
}

