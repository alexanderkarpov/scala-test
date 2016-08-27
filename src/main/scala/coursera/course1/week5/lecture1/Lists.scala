package coursera.course1.week5.lecture1

import scala.collection.immutable.::

/**
  * Created by alexander on 8/18/16.
  */
class Lists {

  def last[T](xs: List[T]): T = xs match {
    case List() => throw new NoSuchElementException
    case List(x) => x
    case y :: ys => last(ys)
  }

  def init[T](xs: List[T]): List[T] = xs match {
    case List() => throw new NoSuchElementException
    case List(x) => List()
    case y :: ys => y :: init(ys)
  }

  //xs ::: ys  ===   ys. ::: (xs)
  def concat[T](xs: List[T], ys: List[T]): List[T] = xs match {
    case List() => ys
    case z :: zs => z :: concat(zs, ys)
  }

  def reverse[T](xs: List[T]): List[T] = xs match {
    case List() => xs
    case y :: ys => reverse(ys) ++ List(y) // ++ equals to :::
  }

  def drop[T](xs: List[T], n: Int): List[T] = xs match {
    case List() => xs
    case List(x) if n <= 0 => xs
    case List(x) => List()
    case y :: ys if n <= 0 => xs
    case y :: ys => drop(ys, n - 1)
  }

  def removeAt[T](xs: List[T], n: Int): List[T] = (xs take n) ::: (xs drop (n + 1))

  def flatten(xs: List[Any]): List[Any] = ???

  //flatten(List(List(1, 1), 2, List(3, List(5, 8))))

}

object Test extends App {

  val lists = new Lists
  val list = List(1, 2, 3, 4, 5)

  println(lists.last(list))
  println(lists.init(list))

  println(lists.concat(List(1, 2, 3, 4), List(5, 6, 7, 8)))

  println(lists.reverse(List(0, 1, 2, 3, 4, 5, 6, 7)))

  println(lists.drop(List(0, 1, 2, 3, 4, 5, 6, 7), 4))

  println(lists.removeAt(List(0, 1, 2, 3, 4, 5, 6, 7), 4))

}
