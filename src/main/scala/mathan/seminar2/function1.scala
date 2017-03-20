package mathan.seminar2

import math._

object function1 extends App {

  def f1(x: Double) = -3.0

  def f2(x: Double) = -(x * x) - 2 * x

  def f3(x: Double) = 1 / (x - 1) + 1

  def f4(x: Double) = -x + 4

  def f(x: Double) = x match {
    case _ if (x >= -4 && x <= -3) => f1(x)
    case _ if (x >= -3 && x <= 0) => f2(x)
    case _ if (x >= 0 && x <= 2) => f3(x)
    case _ if (x >= 2 && x <= 4) => f4(x)
    case _ => throw new IllegalArgumentException(s"function is not defined for x=$x")
  }

  def drawFunctionTable(f: Double => Double, name: String): Unit = {
    println(name + ":")
    printf("%3s|%3s\n", "X", "Y")
    printf("%3s|%3s\n", "---", "---")
    (-3.0 to 3.0).by(0.1).foreach(x =>
      printf("%1.2f|%1.2f\n", x, f(x))
    )
    println()

  }

  def task1(x: Double) = 2 * f(2 * x + 4) + 3

  def task2(x: Double) = -f(-1 - abs(x))

//  println(task1(-0.99))

//  drawFunctionTable(task1, "task1")
  drawFunctionTable(task2, "task2")

}
