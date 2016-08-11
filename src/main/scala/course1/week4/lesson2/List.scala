package course1.week4.lesson2

/**
  * Created by alexander on 8/11/16.
  */
trait List[T] {

  def isEmpty: Boolean

  def head: T

  def tail: List[T]

}

class Cons[T](val head: T, val tail: List[T]) extends List[T] {
  override def isEmpty: Boolean = false
}

class Nil[T] extends List[T] {
  override def isEmpty: Boolean = true

  override def head: Nothing = throw new NoSuchElementException("Nil.head")

  override def tail: Nothing = throw new NoSuchElementException("Nil.tail")
}

object List {

  def apply[T]: List[T] = new Nil

  def apply[T](x0: T): List[T] = new Cons(x0, apply)

  def apply[T](x0: T, x1: T): List[T] = new Cons(x0, apply(x1))

}
