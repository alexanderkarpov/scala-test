package coursera.course2.week2.lecture2.water

/**
  * Created by alexander on 9/14/16.
  */
object PouringTest extends App {

  val problem = new Pouring(Vector(4, 7))
  val moves = problem.moves
  val pathSets = problem.pathSets.take(3).toList

  println(moves)
  println(pathSets)

  val solutions = problem.solutions(6)

  println(solutions)

}
