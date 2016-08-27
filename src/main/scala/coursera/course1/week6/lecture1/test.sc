val xs = Array(1, 2, 3, 4, 5)
xs map (x => x * 2) foreach (x => print(x + " "))

val s = "Hello World"
s.filter(c => c.isUpper)
s.exists(c => c.isUpper)
s.forall(c => c.isUpper)

val r: Range = 1 until 5
val t: Range = 1 to 5
1 to 10 by 3
6 to 1 by -2

val pairs = List(1, 2, 3) zip s
pairs.unzip

s.flatMap(c => List('[', c, ']'))

def scalarProduct(xs: Vector[Double], ys: Vector[Double]): Double =
  (xs zip ys).map { case (x, y) => x * y }.sum
//  (xs zip ys).map(xy => xy._1 * xy._2).sum

scalarProduct(Vector(1, 2, 3), Vector(3, 2, 1))

def isPrime(n: Int): Boolean =
  (2 until n).forall(x => n % x != 0)

isPrime(2)
