package coursera.course2.week1.lecture1

case class Book(title: String, authors: List[String])

object Queries extends App {

  //Lecture 1.1
  //Queries with FOR

  val books: List[Book] = List(
    Book(title = "Structure and Interpretation of Computer Programs", authors = List("Abelson, Gerald", "Susan, Gerald J.")),
    Book(title = "Introduction to Functional Programming", authors = List("Bird, Richard", "Wadler, Phil")),
    Book(title = "Effective Java", authors = List("Bloch, Joshua")),
    Book(title = "Effective Java 2", authors = List("Bloch, Joshua")),
    Book(title = "Effective Java 3", authors = List("Bloch, Joshua")),
    Book(title = "Java Puzzlers", authors = List("Bloch, Joshua", "Gafter, Neal")),
    Book(title = "Java Puzzlers 2", authors = List("Bloch, Joshua", "Gafter, Neal")),
    Book(title = "Programming in Scala", authors = List("Odersky, Martin", "Spoon, Lex", "Venners, Bill"))
  )

  val res0 = for (b <- books; a <- b.authors if a.startsWith("Bird,")) yield b.title

  println(res0)

  val res1 = for (b <- books if b.title.indexOf("Program") > 0) yield b.title
  println(res1)

  //find names of the authors who have written at least two books
  var res2 = (for {
    b1 <- books
    b2 <- books
    if b1.title < b2.title
    a1 <- b1.authors
    a2 <- b2.authors
    if a1 == a2
  } yield a1).distinct
  //    yield (a1, b1.title, b2.title)
  println(res2 mkString("[", "; ", "]"))


  //Lecture 1.2
  //Translation of FOR

  def mapFun[T, U](xs: List[T], f: T => U): List[U] = for (x <- xs) yield f(x)

  def flatMap[T, U](xs: List[T], f: T => Iterable[U]): List[U] = for (x <- xs; y <- f(x)) yield y

  def filter[T](xs: List[T], p: T => Boolean): List[T] = for (x <- xs if p(x)) yield x

  val iter = (0 until 10).withFilter(x => x % 2 == 0).map(a => a) //withFilter is a lazy variant of the filter
  println(iter)

  //  for(x <- e1; y <- e2; s) yield e3  === e1.flatMap(x => (y <- e2; s) yield e3)

  // for(b <- books; a <- b.authors if a.startsWith("Bird,")) yield b.title

  val transRes = books.flatMap(b =>
    //    for ( a <- b.authors.withFilter(a => a.startsWith("Bird,"))) yield b.title
    b.authors.withFilter(a => a.startsWith("Bloch,")) map (a => b.title)
  )

  println(transRes)

  //TODO: clarify distinguishes between filter and withFilter


  //Lecture 1.3
  //Functional Random Generators
  trait SadGenerator[+T] {
    def generate: T
  }

  val sadIntegers = new SadGenerator[Int] {
    val rand = new java.util.Random

    override def generate: Int = rand.nextInt
  }

  val sadBooleans = new SadGenerator[Boolean] {
    override def generate: Boolean = sadIntegers.generate > 0
  }

  val sadPairs = new SadGenerator[(Int, Int)] {
    override def generate: (Int, Int) = (sadIntegers.generate, sadIntegers.generate)
  }


  trait Generator[+T] {
    self =>
    // an alias for "this"

    def generate: T

    def map[S](f: T => S): Generator[S] = new Generator[S] {
      override def generate: S = f(self.generate)
    }

    def flatMap[S](f: T => Generator[S]): Generator[S] = new Generator[S] {
      override def generate: S = f(self.generate).generate
    }
  }

  def single[T](x: T): Generator[T] = new Generator[T] {
    override def generate: T = x
  }

  val integers = new Generator[Int] {
    val rand = new java.util.Random

    override def generate: Int = rand.nextInt
  }

  def booleans = new Generator[Boolean] {
    override def generate: Boolean = integers.generate > -10
  }

  def abs(x: Int): Int = if (x < 0) x * (-1) else x

  def choose(lo: Int, hi: Int): Generator[Int] = for (x <- integers) yield lo + abs(x) % (hi - lo)

  def oneOf[T](xs: T*): Generator[T] = for (idx <- choose(0, xs.length)) yield xs(idx)

  val fruits = oneOf("orange", "apple", "pineapple")

  (0 to 10).foreach(x => println(choose(0, 10).generate))
  println(fruits.generate)

  def lists: Generator[List[Int]] = for {
    isEmpty <- booleans
    list <- if (isEmpty) emptyLists else nonEmptyLists
  } yield list

  def emptyLists = single(Nil)

  def nonEmptyLists = for {
    head <- integers
    tail <- lists
  } yield head :: tail


  def randomList = lists.generate

  println(randomList)
  println(randomList)
  println(randomList)
  println(randomList)


  trait Tree {}

  case class Inner(left: Tree, right: Tree) extends Tree {
    override def toString: String = "[" + left + "," + right + "]"
  }

  case class Leaf(x: Int) extends Tree {
    override def toString: String = x.toString
  }

  def leafs: Generator[Leaf] = single(Leaf(integers.generate))

  def inners: Generator[Inner] = new Generator[Inner] {
    override def generate: Inner = Inner(trees.generate, trees.generate)
  }

  def trees: Generator[Tree] = for {
    isLeaf <- booleans
    tree <- if (isLeaf) leafs else inners
  } yield tree

  println("TREES: " + trees.generate)
  println("TREES: " + trees.generate)
  println("TREES: " + trees.generate)

}
