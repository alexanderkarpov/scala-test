import course1.week6.assignment.forcomp.Anagrams.Occurrences

object test {

  def combinations(occurrences: Occurrences): List[Occurrences] =
    (occurrences foldRight List[Occurrences](Nil)) {
      case ((ch, tm), acc) => {
        acc ++ (for {comb <- acc; n <- 1 to tm} yield (ch, n) :: comb)
      }
    }

//  combinations(List(('a', 2), ('b', 2))).foreach(println)

  val occurrences = List(('a', 2), ('b', 2))
  (occurrences foldRight List[Occurrences](Nil)) {
    case ((ch, tm), acc) => {
      println("(ch, tm) = " + (ch, tm) + "; acc = " + acc)
      acc ++ (for {comb <- acc; n <- 1 to tm} yield (ch, n) :: comb)
    }
  }
}