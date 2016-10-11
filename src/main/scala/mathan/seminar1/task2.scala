package mathan.seminar1

object task2 extends App {


  def sumOddNumbers(n: Int) = Stream.from(1).filter(x => x % 2 != 0).take(n).sum

  def sumOfSquares(n: Int) = Stream.from(1).map(x => x * x).take(n).sum

  def drawTable(maxN: Int, f: Int => Int, name: String): Unit = {
    println(s"$name:")
    printf("%3s|%3s\n", "n", "sum")
    printf("%3s|%3s\n", "---", "---")
    (1 to maxN).foreach(n =>
      printf("%3d|%3d\n", n, f(n))
    )
    printf("%3s-%3s\n\n", "---", "---")
  }

  drawTable(10, sumOddNumbers, "sum first n natural odd numbers")

  drawTable(10, sumOfSquares, "sum of squares of first n natural numbers")
  drawTable(10, n => n * (n + 1) * (2 * n + 1) / 6, "sum of squares of first n natural numbers")
  //  drawTable(10, k => (Math.pow(k + 1, 3)).toInt - k*k*k , "sum of squares of first n natural numbers")
  //http://easymath.com.ua/suma_pervoj_stepeni_kvadratov_kubov_pervyh_n_naruralnyh_chisel.php

  //  println(Stream.from(1).filter(x => x % 2 != 0).take(5).toList)
//  println(Stream.from(1).map(x => x * x).take(5).toList)


  def sum(n: Int) = 2 * (for (k <- (0 to n)) yield (n * n - (2 + 2 * k) * n)).sum

  drawTable(10, sum, "sum of squares of first n natural numbers")

}
