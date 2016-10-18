object PatternMatching {

  val foodItem = "porridge"

  def goldilocks(expr: Any) = expr match {
    case (`foodItem`, _) ⇒ "eating"
    case ("chair", "Mama") ⇒ "sitting"
    case ("bed", "Baby") ⇒ "sleeping"
    case _ ⇒ "what?"
  }


  goldilocks(("porridge", "Papa"))


  case class Dog(name: String, breed: String)

  val d1 = Dog("Scooby", "Doberman")

  d1.toString

  val d2 = d1.copy(name = "Scooby Doo")

  d2.toString


  case class Person(first: String, last: String, age: Int = 0, ssn: String = "")

  val p1 = Person("Fred", "Jones", 23, "111-22-3333")
  val p2 = Person("Samantha", "Jones")
  // note missing age and ssn
  val p3 = Person(last = "Jones", first = "Fred", ssn = "111-22-3333")
  // note the order can change, and missing age
  val p4 = p3.copy(age = 23)

  val parts = Person.unapply(p1).get // this seems weird, but it's critical to other features of Scala


  val someNumbers = Range(2, 10, 3)
  // 3 - increment
  val second = someNumbers(1)
  val last = someNumbers.last
}