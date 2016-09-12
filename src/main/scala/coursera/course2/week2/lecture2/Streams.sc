object Streams {

  val xs = Stream.cons(1, Stream.cons(2, Stream.empty))

  Stream(1, 2, 3)

  (1 to 1000).toStream

  0 #:: xs

  def streamRange(lo: Int, hi: Int): Stream[Int] = {
    print(lo + " ")
    if (lo >= hi) Stream.empty
    else Stream.cons(lo, streamRange(lo + 1, hi))
  }

  streamRange(0, 10).take(3).toList

//  s.toList
//
//  val stream = (1 to 10).toStream.filter(a => a % 2 == 0)
//  stream.toList
//  stream.head
//  stream.tail
//  stream.take(3).toList
//  val s: Stream[Int] =

  //  lo = 1, hi = 10
  //  lo = 1, hi = 10
  //  lo = 1, hi = 10
  //  lo = 1, hi = 10
  //  lo = 1, hi = 10
}