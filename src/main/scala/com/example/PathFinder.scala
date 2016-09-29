package com.example

import java.util.concurrent.atomic.AtomicLong

object PathFinder extends App {


  def totalWeight(root: TreeNode): Double = {

    def loop(node: TreeNode, acc: Double): Double = {
      if (node == null) acc
      else node.nodes match {
        case Nil => node.weight + acc
        case head :: Nil => loop(head, node.weight) + acc
        case head :: tail => {
          val headNodeWeight = loop(head, node.weight)
          val middleNodesWeights: List[Double] = (for (i <- (0 until tail.length - 1)) yield loop(tail(i), 0.0)).toList
          val lastNodeWeight = loop(tail.last, acc)
          headNodeWeight + middleNodesWeights.sum + lastNodeWeight
        }
      }
    }

    loop(root, 0.0)
  }

  type TreePath = List[TreeNode]

  def getAllThreePaths(root: TreeNode): List[TreePath] = {

    def loop(node: TreeNode, acc: List[TreePath], currentPath: TreePath): List[TreePath] = {
      if (node == null) acc ::: List(currentPath)
      else
        node.nodes match {
          case Nil => loop(null, acc, currentPath ::: List(node))
          //        case head :: Nil => loop(head, acc, currentPath ::: List(node))
          case childNodes => {
            val path = currentPath ::: List(node)
            val listOfLists: List[List[TreePath]] = childNodes.map(childNode => loop(childNode, acc, path))
            (listOfLists foldRight List[TreePath]()) ((a, b) => a ::: b)
          }
        }
    }

    loop(root, List(), List())
  }

  type Path = List[CheckPoint]

  def getAllPaths(fromId: Long, toId: Long, checkPoints: List[CheckPoint]): Set[Path] = {

    val possibleMoves: Map[Long, List[CheckPoint]] = checkPoints.groupBy(_.id) withDefaultValue Nil



    def loop(point: CheckPoint, acc: List[Path], currentPath: Path, exploredInCurrentPath: Set[CheckPoint]): List[Path] = {
      if (point == null) {
        currentPath match {
          case Nil => acc
          case list if list.last.nextId == toId => acc ::: List(currentPath)
          case list => acc
        }
      }
      else
        possibleMoves(point.nextId) match {
          case Nil => loop(null, acc, currentPath ::: List(point), exploredInCurrentPath)
          case nextPoints =>
            if (point.nextId == toId) loop(null, acc, currentPath ::: List(point), exploredInCurrentPath)
            else {
              if(exploredInCurrentPath.contains(point)) loop(null, acc, currentPath ::: List(point), exploredInCurrentPath)
              else {
                val path = currentPath ::: List(point)
                val listOfLists: List[List[Path]] = nextPoints.map(nextPoint => loop(nextPoint, acc, path, exploredInCurrentPath + point))
                listOfLists.flatMap(list => list)
              }
            }
        }
    }

    val possibleStartPoints = possibleMoves(fromId)

    val listOfResults: List[List[Path]] = possibleStartPoints.map(startPoint => loop(startPoint, Nil, Nil, Set()))
    listOfResults.flatMap(list => list).toSet

  }

  val id = new AtomicLong

  def nextId: Long = id.incrementAndGet

  def Node(weight: Double, children: TreeNode*) = TreeNode(nextId, weight, children.toList)

  val tree = Node(1, Node(2, Node(3), Node(3), Node(3), Node(3)), Node(2, Node(3), Node(3)), Node(2, Node(3), Node(2)))

  println(totalWeight(tree))

  println(tree)


  def printTreePaths(tree: TreeNode): Unit = {
    println("-------------------")
    val paths = getAllThreePaths(tree)
    paths.foreach(list => println(list.map(node => (node.id, node.weight)).mkString("[", "; ", "]")))
  }


  val tree0 = Node(1)
  printTreePaths(tree0)

  val tree1 = Node(1, Node(2, Node(3)))
  printTreePaths(tree1)

  val tree2 = Node(1, Node(2), Node(3, Node(4), Node(5), Node(6), Node(7, Node(8))), Node(9))
  printTreePaths(tree2)


  def printPath(fromId: Long, toId: Long, checkPoints: List[CheckPoint]): Unit = {
    println("-------------------")
    println(s"the path from $fromId to $toId:")
    val paths = getAllPaths(fromId, toId, checkPoints)
    paths.foreach(list => println(list.mkString(", ")))
  }

  val points0 = List(CheckPoint(1, 2, 10), CheckPoint(2, 3, 20), CheckPoint(3, 4, 30))
  printPath(1, 4, points0)

  val points1 = points0 ::: List(CheckPoint(1, 5, 40), CheckPoint(5, 4, 50), CheckPoint(5, 3, 60), CheckPoint(5, 2, 70), CheckPoint(3, 6, 80))
  printPath(1, 4, points1)
  printPath(1, 2, points1)

  val points3 = points1 ::: List(CheckPoint(3, 2, 90))
  println("============")
  printPath(1, 4, points3)

  val points4 = List(CheckPoint(1, 2, 10), CheckPoint(2, 3, 20), CheckPoint(3, 4, 30), CheckPoint(3, 4, 40),  CheckPoint(0, 5, 50))
  printPath(1, 4, points4) //TODO: this returns two similar paths - need to be investigated
  printPath(1, 2, points4)

}

case class TreeNode(id: Long, weight: Double, nodes: List[TreeNode]) {
  override def toString: String = s"[id=$id, weight=$weight, {${nodes.mkString(",")}}"
}

case class CheckPoint(id: Long, nextId: Long, weight: Double)


