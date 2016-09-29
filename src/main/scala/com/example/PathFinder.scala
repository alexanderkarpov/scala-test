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

  type Path = List[TreeNode]

  def getAllPaths(root: TreeNode): List[Path] = {

    def loop(node: TreeNode, acc: List[Path], currentPath: Path): List[Path] = {
      if(node == null) acc ::: List(currentPath)
      else node.nodes match {
        case Nil => loop(null, acc, currentPath ::: List(node))
        case head :: Nil => loop(head, acc, currentPath ::: List(node))
        case List(left, right) => {
          val path = currentPath ::: List(node)
          loop(left, acc, path) ::: loop(right, acc, path)
        }
//        case List(left, right) => {
//          val newPath = currentPath ::: List(node)
//
//        }
      }


    }

    loop(root, List(), List())

  }

  val id = new AtomicLong

  def nextId = id.incrementAndGet

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

  val tree2 = Node(1, Node(2), Node(3, Node(4), Node(5)))
  printPaths(tree2)


}

case class TreeNode(id: Long, weight: Double, nodes: List[TreeNode]) {
  override def toString: String = s"[id=$id, weight=$weight, {${nodes.mkString(",")}}"
}

case class CheckPoint(id: Long, nextId: Long, weight: Double)
