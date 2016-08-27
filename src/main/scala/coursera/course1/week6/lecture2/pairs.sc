object pairs {

  def isPrime(n: Int): Boolean =
    (2 until n).forall(x => n % x != 0)

  val n = 7
  (1 until n) map (i => (1 until i) map (j => (i, j))) flatten;
  (1 until n) flatMap (i => (1 until i) map (j => (i, j)));
  (1 until n) flatMap (i => (1 until i) map (j => (i, j))) filter (p => isPrime(p._1 + p._2))

  for {
    i <- 1 until n
    j <- 1 until n
    if isPrime(i + j)
  } yield (i, j)


  def scalarProduct(xs: List[Double], ys: List[Double]): Double =
    (for ((x, y) <- xs zip ys) yield x * y).sum


}