import scala.io.Source

object files {

  val path = "/home/alexander/GIT/scala-test/src/main/scala/books/odersky/chapter3/files.sc"

  val lines = Source.fromFile(path).getLines().toList;

  def longestLine(lines: List[String]): String = {
    lines.reduceLeft((a, b) => if(a.length > b.length) a else b )
  }

  longestLine(lines)
}