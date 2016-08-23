import scala.io.Source

object mnemonics {
//  val in = Source.fromURL("http://lamp.epfl.ch/files/content/sites/lamp/files/teaching/progfun/linuxwords")
//  val in = Source.fromURL("http://txt2html.sourceforge.net/sample.txt")
//  val words = in.getLines().toList filter (word => word forall (ch => ch.isLetter))
  val text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."

  val words = text.split("\\s").toList filter (word => word forall (ch => ch.isLetter)) map (str => str.toUpperCase)
  val mnem = Map (
    '2' -> "ABC", '3' -> "DEF", '4' -> "GHI", '5' -> "JKL",
    '6' -> "MNOP", '7' -> "QRS", '8' -> "TUV", '9' -> "WXYZ"
  )

  val charCode: Map [Char, Char] =
    for((digit, str) <- mnem; ltr <- str) yield ltr -> digit

  def wordCode(word: String): String =
    word.toUpperCase map charCode
//    for(ch <- word) yield charCode(ch.toUpper)

  wordCode("Java")

  /**
    * A map from digit strings to the words that represents them,
    * e.g. "5282" -> List("Java", "Kata", "Lava", ...)
    * A missing number return an empty set
    */
  val wordsForNum: Map[String, Seq[String]] = words groupBy wordCode
}