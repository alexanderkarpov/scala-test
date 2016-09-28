package com.example

object PathFinder extends App {


  def totalWeight(root: TreeNode): Double = {

    def loop(node: TreeNode, acc: Double): Double = {
      if(node == null) acc
      else loop(node.leftNode, node.weight) + loop(node.rightNode, acc)
    }

    loop(root, 0.0)
  }

  val smallTree = TreeNode(1, TreeNode(1, null, null), TreeNode(1, null, null))
  println(totalWeight(smallTree))

  val largeTree = TreeNode(1, TreeNode(2, TreeNode(3, TreeNode(4, TreeNode(5, TreeNode(6, null, null), null), TreeNode(7, null, null)), null), TreeNode(8, TreeNode(9, null, null), TreeNode(10, null, null))), TreeNode(11, TreeNode(12, TreeNode(13, null, TreeNode(14, null, null)), null), TreeNode(15, TreeNode(16, null, null), TreeNode(17, TreeNode(18, null, null), TreeNode(19, TreeNode(20, null, null), null)))))

  println(totalWeight(largeTree))


}

case class TreeNode(weight: Double, leftNode: TreeNode, rightNode: TreeNode) {
  def hasLeftNode = leftNode != null

  def hasRightNode = rightNode != null
}

case class CheckPoint(id: Long, nextId: Long, weight: Double)
