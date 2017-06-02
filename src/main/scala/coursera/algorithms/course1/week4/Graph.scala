package coursera.algorithms.course1.week4

case class Graph(edges: List[(Int, Int)]) {

  def this() = this(Nil)

  def addEdge(v1: Int, v2: Int) = {
    if (v1 == v2) this
    else Graph(makeEdge(v1, v2) :: edges)
  }

  def removeEdge(v1: Int, v2: Int): Graph = {
    val edge = makeEdge(v1, v2)
    if (!edges.toSet.contains(edge)) throw new IllegalArgumentException("edge not found")

    def affectCondition(p: (Int, Int), v: Int) = p._1 == v || p._2 == v

    val affectedEdges = edges.filter(p => affectCondition(p, edge._1)).filter(p => p != edge)
      .map(e => {
        if (e._1 == edge._1) (edge._2, e._2)
        else (e._1, edge._2)
      })
      .map(e => makeEdge(e._1, e._2))

    val notAffectedEdges = edges.filter(p => !affectCondition(p, edge._1)).filter(p => p != edge)

    Graph((affectedEdges ::: notAffectedEdges).filter(e => e._1 != e._2))
  }

  private def makeEdge(v1: Int, v2: Int) = (Math.min(v1, v2), Math.max(v1, v2))
}


