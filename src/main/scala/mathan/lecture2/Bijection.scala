package mathan.lecture2


object Bijection extends App {

  def minusOnePow(x: Int): Int = if (x % 2 == 0) 1 else -1

  def maxNatIntNotMoreExpr(expr: Int => Int, n: Int): Int = {

    def loop(curr: Int): Int = {
      if (curr > expr(n)) curr - 1
      else loop(curr + 1)
    }

    if (1 > expr(n)) throw new NoSuchElementException
    else loop(1)
  }

  def expr(n: Int): Int = (n + 1) / 2

//  (1 to 10).foreach(n => {
//    val maxInt = maxNatIntNotMoreExpr(expr, n)
//    println(s"$n\t$maxInt")
//  })

  def option1(n: Int): Int = minusOnePow(n) * maxNatIntNotMoreExpr(expr, n) + (minusOnePow(n) + 1) / 2

  def option2(n: Int): Int = minusOnePow(n) * maxNatIntNotMoreExpr(expr, n) + (minusOnePow(n + 1) + 1) / 2

  def option3(n: Int): Int = minusOnePow(n) * maxNatIntNotMoreExpr(expr, n) + (minusOnePow(n + 1) - 1) / 2

  def option4(n: Int): Int = minusOnePow(n + 1) * maxNatIntNotMoreExpr(expr, n) + (minusOnePow(n) + 1) / 2

  def option5(n: Int): Int = minusOnePow(n + 1) * maxNatIntNotMoreExpr(expr, n) + (minusOnePow(n) - 1) / 2


  def drawFunctionTable(f: Int => Int, name: String): Unit = {
    println(name + ":")
    printf("%3s|%3s\n", "X","Y")
    printf("%3s|%3s\n", "---", "---")
    (1 to 10).foreach(n =>
      printf("%3d|%3d\n", n, f(n))
    )
    println()

  }

  drawFunctionTable(option1, "[1]")
  drawFunctionTable(option2, "[2]")
  drawFunctionTable(option3, "[3]")
  drawFunctionTable(option4, "[4]")
  drawFunctionTable(option5, "[5]")


}
