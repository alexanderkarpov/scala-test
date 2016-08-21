object maps {

  val romanNumerals = Map('I' -> 1, 'V' -> 5, 'X' -> 10)
  val capitalOfCountry = Map(
    "US" -> "Washington",
    "Switzerland" -> "Bern"
  )

  capitalOfCountry get "andorra"
  capitalOfCountry get "US"

  def showCapital(country: String) = capitalOfCountry.get(country) match {
    case Some(capital) => capital
    case None => "not found"
  }

  showCapital("Switzerland")
  showCapital("Italy")

  val cap1 = capitalOfCountry withDefaultValue "unknown"
  cap1("andorra")

  val fruits = List("orange", "pineapple", "apple", "pear")
  fruits.sortWith(_.length < _.length)
  fruits.groupBy(_.head)

}