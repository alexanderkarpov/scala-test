object Options {
  val someValue: Option[String] = Some("I am wrapped in something")

  someValue.get

  val emptyValue: Option[String] = None
  emptyValue.orElse(Some("preved")).get

  emptyValue.getOrElse("fff")
  someValue.getOrElse("fff")

  emptyValue.getOrElse{"default function"}

  val doubleValue: Option[Double] = Some(20.0)
  val value = doubleValue match {
    case Some(v) => v
    case None => 0.0
  }

  val number: Option[Int] = Some(3)
  val noNumber: Option[Int] = None

  val result1 = number.map(_ * 1.5)
  val result2 = noNumber.map(_ * 2)

  //Another operation is fold. this operation will extract the value from the option,
  // or provide a default if the value is None
  val result3 = number.fold(2000.2)(_ * 3)
}
