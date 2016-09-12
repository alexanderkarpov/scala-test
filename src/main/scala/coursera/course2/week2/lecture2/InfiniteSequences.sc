object InfiniteSequences {

  def from(n: Int):Stream[Int] = n #:: from(n + 1)

  from(10).take(10).toList

  val nats = from(0)
  nats map (_ * 4) take 10 toList

  /**
    * finds prime numbers in the stream
    * @param s
    * @return
    */
  def sieve(s: Stream[Int]): Stream[Int] = {
    if(s.head < 2) throw new IllegalArgumentException
    s.head #:: sieve(s.tail filter (_ % s.head != 0))
  }


  val primes = sieve(from(2))

  primes.take(10).toList

  def sqrtStream(x: Double): Stream[Double] = {
    def improve(guess: Double) = (guess + x / guess) / 2
    lazy val guesses: Stream[Double] = 1 #:: (guesses map improve)
    guesses
  }

  sqrtStream(25).take(10).toList
}