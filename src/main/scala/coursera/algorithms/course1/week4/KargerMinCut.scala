package coursera.algorithms.course1.week4

import scala.io.Source

/**
  * Created by alexander on 6/3/17.
  */
object KargerMinCut {

  def main(args: Array[String]): Unit = {
    val filename = "src/main/resources/algorithms/kargerMinCut.txt"
    val edges = Source.fromFile(filename).getLines().flatMap(parseLine).toList

    val graph = makeGraph(edges)
    println(s"min cut: ${minCut(graph)}")
  }

  def minCut(graph: Graph): Int = {

    def loop(n: Int, acc: List[Int]): List[Int] = {

      if(n <= 0) acc
      else {
        val nextResult = graph.randomContraction.edges.size
        println(s"$n: $nextResult")
        loop(n - 1, nextResult :: acc)
      }
    }

    val results = loop(graph.getVertices.size, Nil)
    results.min
  }

  def parseLine(line: String): List[(Int, Int)] = {
    val args = line.split("\t")
    val vertex = Integer.parseInt(args(0))
    args.map(s => (vertex, Integer.parseInt(s))).toList
  }

  def makeGraph(edges: List[(Int, Int)]): Graph = {

    def loop(edges: List[(Int, Int)], acc: Graph): Graph = edges match {
      case Nil => acc
      case h::tail => loop(tail, acc.addEdge(h._1, h._2))
    }

    loop(edges, new Graph())
  }

}
