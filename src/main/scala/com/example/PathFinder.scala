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

  def getAllPaths(root: TreeNode): List[TreePath] = {

    def loop(node: TreeNode, acc: List[TreePath], currentPath: TreePath): List[TreePath] = {
      if(node == null) acc ::: List(currentPath)
      else
        node.nodes match {
        case Nil => loop(null, acc, currentPath ::: List(node))
        case head :: Nil => loop(head, acc, currentPath ::: List(node))
        case childNodes => {
          val path = currentPath ::: List(node)
          val listOfLists: List[List[TreePath]] = childNodes.map(childNode => loop(childNode, acc, path))
          (listOfLists foldRight List[TreePath]()) ((a, b) => a ::: b)
        }
      }
    }

    loop(root, List(), List())
  }

  type Path = List[Long]
  case class CheckPoint(id: Long, nextId: Long, weight: Double)

  def getAllPossiblePaths(fromId: Long, toId: Long, checkPoints: List[CheckPoint]): List[Path] = {

    val possibleMoves: Map[Long, List[CheckPoint]] = checkPoints.groupBy(_.id) withDefaultValue Nil

//    def loop(point: CheckPoint, acc: List[Path], currentPath: Path): List[Path] = {
//
//    }
    ???

  }

  val id = new AtomicLong

  def nextId: Long = id.incrementAndGet

  def Node(weight: Double, children: TreeNode*) = TreeNode(nextId, weight, children.toList)

  val tree = Node(1, Node(2, Node(3), Node(3), Node(3), Node(3)), Node(2, Node(3), Node(3)), Node(2, Node(3), Node(2)))

  println(totalWeight(tree))

  println(tree)


  def printPaths(tree: TreeNode): Unit = {
    println("-------------------")
    val paths = getAllPaths(tree)
    paths.foreach(list => println(list.map(node => (node.id, node.weight)).mkString("[","; ","]")))
  }



  val tree1 = Node(1, Node(2, Node(3)))
  printPaths(tree1)

  val tree2 = Node(1, Node(2), Node(3, Node(4), Node(5), Node(6), Node(7)))
  printPaths(tree2)


  val map: Map[Long, String] = Map(1L -> "111", 2L -> "222") withDefaultValue "UNKNOWN"

  println(map(3))


}

case class TreeNode(id: Long, weight: Double, nodes: List[TreeNode]) {
  override def toString: String = s"[id=$id, weight=$weight, {${nodes.mkString(",")}}"
}


