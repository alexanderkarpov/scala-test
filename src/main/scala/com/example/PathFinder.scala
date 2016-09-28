package com.example

object PathFinder extends App {


  def totalWeight(root: TreeNode): Double = {

    def loop(node: TreeNode, acc: Double): Double = {
      if(node == null) acc
      else node.nodes match {
        case Nil => node.weight + acc
        case head::Nil => loop(head, node.weight) + acc
        case head::tail => {
          val headNodeWeight = loop(head, node.weight)
          val middleNodesWeights: List[Double] = (for(i <- (0 until tail.length - 1)) yield loop(tail(i), 0.0)).toList
          val lastNodeWeight = loop(tail.last, acc)
          headNodeWeight + middleNodesWeights.sum + lastNodeWeight
        }
      }
    }

    loop(root, 0.0)
  }

 def Node(weight: Double, children: TreeNode*) = TreeNode(weight, children.toList)

  val tree = Node(1, Node(2, Node(3), Node(3), Node(3), Node(3)), Node(2, Node(3), Node(3)), Node(2, Node(3), Node(2)))

  println(totalWeight(tree))

//  val smallTree = TreeNode(1, TreeNode(1, null, null), TreeNode(1, null, null))
//  println(totalWeight(smallTree))
//
//  val largeTree = TreeNode(1, TreeNode(2, TreeNode(3, TreeNode(4, TreeNode(5, TreeNode(6, null, null), null), TreeNode(7, null, null)), null), TreeNode(8, TreeNode(9, null, null), TreeNode(10, null, null))), TreeNode(11, TreeNode(12, TreeNode(13, null, TreeNode(14, null, null)), null), TreeNode(15, TreeNode(16, null, null), TreeNode(17, TreeNode(18, null, null), TreeNode(19, TreeNode(20, null, null), null)))))
//
//  println(totalWeight(largeTree))


}

case class TreeNode(weight: Double, nodes: List[TreeNode]) {
  def this(weight: Double) = this(weight, Nil)
}

case class CheckPoint(id: Long, nextId: Long, weight: Double)
