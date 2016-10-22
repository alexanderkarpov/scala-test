object Implicits {

  class KoanIntWrapper(val original: Int) {
    def isOdd = original % 2 != 0

    def isEven = !isOdd
  }

  implicit def thisMethodNameIsIrrelevant(value: Int) = new KoanIntWrapper(value)

  5.isOdd
  6.isEven

}