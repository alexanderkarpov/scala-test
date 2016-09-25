object Sum100 {

  val n = 100

  val summands = (
    for {
      a <- (1 until n)
      b <- (1 until n)
      c <- (1 until n)
    } yield (List(a, b, c)) //.sorted

    )
    .distinct
    .filter(s => s.sum == n)

  summands.size

//  summands.mkString("\n")

  summands.last








}