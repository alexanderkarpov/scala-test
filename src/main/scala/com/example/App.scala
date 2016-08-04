package com.example

object App {

  def main(args: Array[String]) {

    val binaryTree: BinaryTree = new Node(10, new Empty, new Empty).incl(12).incl(9).incl(4).incl(15).incl(2)

    binaryTree.foreach(i => print("<" + i + ">"))
    println()
    binaryTree.filter(e => e % 3 == 0).foreach(i => print("<" + i + ">"))
  }

}
