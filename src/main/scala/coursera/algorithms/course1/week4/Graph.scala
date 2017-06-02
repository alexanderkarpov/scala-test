package coursera.algorithms.course1.week4

case class Graph(vertices: List[Vertex]) {

  //TODO: Graph(vertices: List[Vertex]) should be a private constructor

  def this(vertex: Vertex) = this(List(vertex))

  val verticesIds: Set[Int] = vertices.map(v => v.id).toSet

  def addVertex(id: Int): Graph = {
    if (verticesIds.contains(id)) throw new IllegalArgumentException(s"vertex $id already exists")
    val list: List[Vertex] = new Vertex(id) :: vertices.toList
    new Graph(list)
  }

  def addEdge(id1: Int, id2: Int): Graph = {
    val map: Map[Int, Vertex] = vertices.map(v => v.id -> v).toMap
    val vertex1 = ???
    val vertex2 = map(id2).edges.map(v => v.id).toSet


  }

  def add(vertex: Vertex): Graph = {
    //TODO: find vertex(vertices) to be connected to the new one
    val verticesToBeConnected: Set[Vertex] = vertices.filter(v => v.edges.toSet.contains(vertex.id))

    //TODO: connect vertices
    ???
  }


}


case class Vertex(id: Int, edges: List[Vertex]) {

  def this(id: Int) = this(id, List.empty)

  def getVerticesIds: Set[Int] = {

    def loop(edges: List[Vertex], acc: List[Int]): List[Int] = edges match {
      case Nil => acc
      case list => list.flatMap(v => loop(v.edges, v.id :: acc))
    }

    loop(edges, List(id)).toSet

  }

  def addEdge(edge: Vertex): Vertex = {
    if(!edges.map(_.id).toSet.contains(edge.id)){
      Vertex(id, edge :: edges)
    } else {
      throw new IllegalArgumentException("already exists")
    }
  }


}


