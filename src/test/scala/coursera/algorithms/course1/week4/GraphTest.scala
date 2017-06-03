package coursera.algorithms.course1.week4

import org.junit.Assert.assertTrue
import org.junit.Test

/**
  * Created by alexander on 6/3/17.
  */
@Test
class GraphTest {

  @Test
  def normalFlow() = {

    val graph = new Graph()
      .addEdge(0, 1)
      .addEdge(1, 2)
      .addEdge(2, 5)
      .addEdge(5, 4)
      .addEdge(1, 4)
      .addEdge(3, 4)
      .addEdge(1, 3)
      .addEdge(0, 3)

    assertTrue(graph.edges.length == 8)

    val graph1 = graph.removeEdge(1, 3)

    assertTrue(graph1.edges.length == 7)
    assertTrue(graph1.edges.count(_ == (0, 3)) == 2)
    assertTrue(graph1.edges.count(_ == (2, 3)) == 1)
    assertTrue(graph1.edges.count(_ == (3, 4)) == 2)
    assertTrue(graph1.edges.count(_ == (4, 5)) == 1)
    assertTrue(graph1.edges.count(_ == (2, 5)) == 1)

    assertTrue(graph.removeEdge(1, 4) == graph.removeEdge(4, 1))

    val graph2 = graph1.removeEdge(3, 0)
    assertTrue(graph2.edges.length == 5)
    assertTrue(graph2.edges.count(_ == (3, 4)) == 2)
    assertTrue(graph2.edges.count(_ == (2, 3)) == 1)
    assertTrue(graph2.edges.count(_ == (2, 5)) == 1)
    assertTrue(graph2.edges.count(_ == (4, 5)) == 1)
  }

  @Test
  def getVerticesTest() = {
    val graph = new Graph()
      .addEdge(0, 1)
      .addEdge(1, 2)
      .addEdge(2, 5)
      .addEdge(5, 4)
      .addEdge(1, 4)
      .addEdge(3, 4)
      .addEdge(1, 3)
      .addEdge(0, 3)

    assertTrue(graph.getVertices == Set(0, 1, 2, 3, 4, 5))
  }

  @Test
  def randomContractionTest() = {
    val graph = new Graph()
      .addEdge(0, 1)
      .addEdge(1, 2)
      .addEdge(2, 3)
      .addEdge(3, 4)
      .addEdge(4, 0)

    assertTrue(graph.randomContraction.edges.length == 2)
  }

}
