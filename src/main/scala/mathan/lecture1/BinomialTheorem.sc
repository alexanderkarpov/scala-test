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

  (0 until 5).foreach(n => println(s"$n: ${pascalTriangle(n).mkString(", ")}"))

  def expand(a: String, b: String, n: Int): String = {
    val coefs = pascalTriangle(n);
    def coef(i: Int) = {
      val n = coefs(i)
      if(n > 1) s"$n * " else ""
    }
    def power(x: String, p: Int): String = {
      if(p == 0) "1"
      else if(p == 1) s"$x"
      else s"$x^$p"
    }
    val res = for(i <- 0 to n) yield s"${coef(i)}${power(a, n-i)} * ${power(b, i)}"

    s"($a + $b)^$n = " + res.toList.mkString(" + ")
  }

  expand("x","y",4)
  
 

}