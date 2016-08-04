package com.example

abstract class BinaryTree {

  def incl(newElem: Int): BinaryTree

  def foreach(f: Int => Unit)

  def filter(p: Int => Boolean): BinaryTree = filterAcc(p, new Empty)

  def filterAcc(p: Int => Boolean, acc: BinaryTree): BinaryTree

  def union(that: BinaryTree): BinaryTree

}

class Empty extends BinaryTree {
  override def incl(newElem: Int): BinaryTree = new Node(newElem, new Empty, new Empty)

  override def foreach(f: (Int) => Unit): Unit = {}

  override def filterAcc(p: (Int) => Boolean, acc: BinaryTree): BinaryTree = acc

  override def union(that: BinaryTree): BinaryTree = that

  override def toString: String = ""
}

class Node(elem: Int, left: BinaryTree, right: BinaryTree) extends BinaryTree {

  override def incl(newElem: Int): BinaryTree =
    if (newElem == elem) this
    else if (newElem < elem) new Node(elem, left incl newElem, right)
    else new Node(elem, left, right incl newElem)

  override def foreach(f: (Int) => Unit): Unit = {
    left.foreach(f)
    f.apply(elem)
    right.foreach(f)
  }

  override def filterAcc(p: (Int) => Boolean, acc: BinaryTree): BinaryTree =
    if(p.apply(elem)) left.filterAcc(p, right.filterAcc(p, acc.incl(elem)))
    else left.filterAcc(p, right.filterAcc(p, acc))

  override def union(that: BinaryTree): BinaryTree = (that union left union right) incl elem

  override def toString: String =  left.toString + " " + elem + " " + right.toString
}


