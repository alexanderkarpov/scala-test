package com.example

object App {

  def main(args: Array[String]) {

    val binaryTree: BinaryTree = new Node(10, new Empty, new Empty)
      .incl(12).incl(9).incl(4).incl(15).incl(2).incl(1).incl(17)

    binaryTree.foreach(i => print("<" + i + ">"))
    println
    binaryTree.filter(e => e % 3 == 0).foreach(i => print("<" + i + ">"))
    println


    val even = binaryTree.filter(e => e % 2 == 0)
    val odd = binaryTree.filter(e => e % 2 != 0)

    println(even)
    println(odd)
    println(odd union even)
  }

}
