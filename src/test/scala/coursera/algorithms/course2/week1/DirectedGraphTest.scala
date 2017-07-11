package coursera.algorithms.course2.week1

import org.junit.Assert.assertTrue
import org.junit.Test

import scala.collection.mutable

/**
  * Created by alexander on 6/28/17.
  */
@Test
class DirectedGraphTest {

  @Test
  def treeDFS() = {

    val tree: Map[Int, List[Int]] = Map(
      1 -> List(2),
      2 -> List(3, 6),
      3 -> List(4, 5),
      6 -> List(7)
    )

    val graph = DirectedGraph(tree)

    val res = graph.depthFirstSearch(1)
    assertEquals(res, List(1, 2, 3, 4, 5, 6, 7))

  }

  @Test
  def cyclicGraphDFS() = {

    val cyclicGraph = Map(
      1 -> List(2),
      2 -> List(3),
      3 -> List(4),
      4 -> List(5),
      5 -> List(1)
    )

    val graph = DirectedGraph(cyclicGraph)

    val res = graph.depthFirstSearch(1)
    assertEquals(res, List(1, 2, 3, 4, 5))
  }

  @Test
  def commonCaseDFS() = {

    val map = Map(
      1 -> List(7),
      7 -> List(9, 4),
      4 -> List(1),
      9 -> List(6),
      6 -> List(8, 3),
      3 -> List(9),
      8 -> List(2),
      2 -> List(5),
      5 -> List(8)
    )

    val expected = List(1, 7, 9, 6, 8, 2, 5, 3, 4)

    assertEquals(DirectedGraph(map).depthFirstSearch(1), expected)

  }

  @Test
  def reverse() = {
    val tree: Map[Int, List[Int]] = Map(
      1 -> List(2),
      2 -> List(3, 6),
      3 -> List(4, 5),
      6 -> List(7)
    )

    val reversedTree: Map[Int, List[Int]] = Map(
      2 -> List(1),
      3 -> List(2),
      6 -> List(2),
      4 -> List(3),
      5 -> List(3),
      7 -> List(6)
    )

    val graph = DirectedGraph(reversedTree)
    graph.reverse

    assertEquals(DirectedGraph(reversedTree).reverse.vertices.map(e => (e._1, e._2.toSet)),
      DirectedGraph(tree).vertices.map(e => (e._1, e._2.toSet)))

    assertEquals(DirectedGraph(tree).reverse.vertices.map(e => (e._1, e._2.toSet)),
      DirectedGraph(reversedTree).vertices.map(e => (e._1, e._2.toSet)))

  }

  @Test
  def dfs() = {
    val map = Map(
      1 -> List(7),
      7 -> List(4, 9),
      4 -> List(1),
      9 -> List(6),
      6 -> List(3, 8),
      3 -> List(9),
      8 -> List(2),
      2 -> List(5),
      5 -> List(8)
    )

    val arr = new Array[Int](9)
    DirectedGraph.dfs(DirectedGraph(map), 9,
      arr, new mutable.HashSet[Int](), new Counter)

    assertEquals(arr.toList, List(0, 3, 1, 0, 2, 5, 0, 4, 6))
  }

  @Test
  def dfsLoop() = {
    val map = Map(
      1 -> List(7),
      7 -> List(4, 9),
      4 -> List(1),
      9 -> List(6),
      6 -> List(3, 8),
      3 -> List(9),
      8 -> List(2),
      2 -> List(5),
      5 -> List(8)
    )

    val res = DirectedGraph.dfsLoop(DirectedGraph(map))
    assertEquals(res, List(7, 3, 1, 8, 2, 5, 9, 4, 6))

    val res2 = DirectedGraph.dfsLoop(DirectedGraph(map).reverse)

    println(s"$res\n$res2")
  }

  def assertEquals[T](actual: T, expected: T): Unit = {
    assertTrue(s"expected $expected but was $actual", actual == expected)
  }


}
