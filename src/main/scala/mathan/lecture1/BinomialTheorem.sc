import scala.annotation.tailrec

object BinomialTheorem {

  //https://www.math10.com/ru/algebra/veroiatnosti/binominalnaya-teorema/binominalnaya-teorema.html

  def pascalTriangle(n: Int): List[Int] = {

    if (n < 0) throw new IllegalArgumentException("n should be >= 0")

    def nextRow(prev: List[Int]): List[Int] = {
      val middle = for (i <- (1 until prev.length))
        yield prev(i) + prev(i - 1)

      1 :: middle.toList ::: List(1)
    }

    @tailrec
    def loop(n: Int, acc: List[Int]): List[Int] = n match {
      case 0 => acc
      case x => loop(x - 1, nextRow(acc))
    }

    loop(n, List(1))

  }

  case class Summand(coef: Int, powA: Int, powB: Int)

  def expand(n: Int): List[Summand] = {
    val coefs = pascalTriangle(n)
    val res = for(i <- 0 to n) yield Summand(coefs(i), n - i, i)
    res.toList
  }

  val summands = expand(30)

  val b = Math.sqrt(2)
  val xCoefPower = summands.map(s => (s.coef * Math.pow(b, s.powB), s.powA ))

  val sorted = xCoefPower.sortBy(_._1)
  sorted.last._2
  
 

}