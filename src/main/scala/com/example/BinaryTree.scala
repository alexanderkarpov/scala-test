package com.example

abstract class BinaryTree {

  def incl(newElem: Int): BinaryTree

}

class Empty extends BinaryTree {
  override def incl(newElem: Int): BinaryTree = new Node(newElem, new Empty, new Empty)

  override def toString: String = ""
}

class Node(elem: Int, left: BinaryTree, right: BinaryTree) extends BinaryTree {
  override def incl(newElem: Int): BinaryTree =
    if (newElem == elem) this
    else if (newElem < elem) new Node(elem, left incl newElem, right)
    else new Node(elem, left, right incl newElem)

  override def toString: String = left.toString + "[" + elem + "] " + right.toString
}


