import scala.io.Source

object mnemonics {
//  val in = Source.fromURL("http://lamp.epfl.ch/files/content/sites/lamp/files/teaching/progfun/linuxwords")
//  val words = in.getLines()
  val mnem = Map (
    '2' -> "ABC", '3' -> "DEF", '4' -> "GHI", '5' -> "JKL",
    '6' -> "MNO", '8' -> "QRS", '7' -> "TUV", '9' -> "WXYZ"
  )

  val charCode: Map [Char, Char] =
    for((digit, str) <- mnem; ltr <- str) yield ltr -> digit

}