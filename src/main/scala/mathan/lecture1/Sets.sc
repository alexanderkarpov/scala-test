object Sets {


  def intersection[T](a: Set[T], b: Set[T]) = a.filter(e => b.contains(e))

  def union[T](a: Set[T], b: Set[T]) = a ++ b

  def subtraction[T](a: Set[T], b: Set[T]) = a.filter(e => !b.contains(e))

  def mult[T](a: Set[T], b: Set[T]): Set[(T,T)] =
    for {
      x <- a
      y <- b
    } yield (x, y)

  def isSubset[T](a: Set[T], b: Set[T]): Boolean = a.forall(b.contains)

  mult(Set(0,1,2), Set(3,4))


//  val a = Set(1, 2)
//  val b = Set(3, 2)
//  val c = Set(4, 2)
//  val d = Set(5, 2)

//  val a: Set[Int] = Set()
//  val b: Set[Int] = Set()
//  val c: Set[Int] = Set()
//  val d: Set[Int] = Set()

    val a = Set(1, 2)
    val b = Set(3, 22)
    val c = Set(4, 222)
    val d = Set(5, 2222)


  val opt1 = isSubset(
    intersection(
      subtraction(a, c),
      subtraction(b, d)),
    subtraction(
      intersection(a, c),
      intersection(b, d)
    )
  )

  val opt2 = isSubset(
    subtraction(
      intersection(a, c),
      intersection(b, d)
    ),
    intersection(
      subtraction(a, c),
      subtraction(b, d))
  )

  val opt3 = isSubset(
    union(
      subtraction(a, c),
      subtraction(b, d)),
    subtraction(
      union(a, c),
      union(b, d)
    )
  )

  val opt4 = isSubset(
    subtraction(
      union(a, c),
      union(b, d)
    ),
    union(
      subtraction(a, c),
      subtraction(b, d))
  )

val opt5 = intersection(mult(a,c), mult(b,d)) ==
  mult(intersection(a,c), intersection(b,d))

}