package coursera.course2.week1.lecture1

case class Book(title: String, authors: List[String])

object Queries extends App {

  //Lecture 1.1

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

  val res0 = for(b <- books; a <- b.authors if a.startsWith("Bird,")) yield b.title

  println(res0)

  val res1 = for(b <- books if b.title.indexOf("Program") > 0) yield b.title
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

  println(res2 mkString ("[", "; ", "]"))



  //Lecture 1.2

  def mapFun[T, U] (xs: List[T], f: T => U): List[U] = for (x <- xs) yield f(x)

  def flatMap[T, U] (xs: List[T], f: T => Iterable[U]): List[U] = for (x <- xs; y <- f(x)) yield y

  def filter[T] (xs: List[T], p: T => Boolean): List[T] = for (x <- xs if p(x)) yield x

  val iter = (0 until 10).withFilter(x => x % 2 == 0).map(a => a) //withFilter is a lazy variant of the filter
  println(iter)

//  for(x <- e1; y <- e2; s) yield e3  === e1.flatMap(x => (y <- e2; s) yield e3)

  // for(b <- books; a <- b.authors if a.startsWith("Bird,")) yield b.title

  val transRes = books.flatMap(b =>
    //    for ( a <- b.authors.withFilter(a => a.startsWith("Bird,"))) yield b.title
    b.authors.withFilter(a => a.startsWith("Bloch,")) map (a => b.title)
  )

  println(transRes)
}
