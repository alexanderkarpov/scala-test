
def discr(a: Double, b: Double, c: Double): Double = b * b - 4 * a * c

def eq(a: Double, b: Double, c: Double): (Double, Double) = {
  val sqrtD = math.sqrt(discr(a,b,c))

  val x1 = (-b + sqrtD) / (2 * a)
  val x2 = (-b - sqrtD) / (2 * a)

  (x1, x2)
}

discr(1, 4, -5)
eq(1, 4, -5)
eq(1, -4, -5)
