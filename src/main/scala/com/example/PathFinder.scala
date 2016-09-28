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

  def getAllPaths(root: TreeNode): Set[List[TreeNode]] = {

    def loop(node: TreeNode, acc: Set[List[TreeNode]]): Set[List[TreeNode]] = ???

    loop(root, Set())

  }

  val id = new AtomicLong

  def nextId = id.incrementAndGet

  def Node(weight: Double, children: TreeNode*) = TreeNode(nextId, weight, children.toList)

  val tree = Node(1, Node(2, Node(3), Node(3), Node(3), Node(3)), Node(2, Node(3), Node(3)), Node(2, Node(3), Node(2)))

  println(totalWeight(tree))

  println(tree)

}

case class TreeNode(id: Long, weight: Double, nodes: List[TreeNode]) {
  override def toString: String = s"[id=$id, weight=$weight, {${nodes.mkString(",")}}"
}

case class CheckPoint(id: Long, nextId: Long, weight: Double)
