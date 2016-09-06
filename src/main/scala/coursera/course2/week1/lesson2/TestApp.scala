package coursera.course2.week1.lesson2

object TestApp extends App {
  val data = JObj(Map(

    "firstName" -> JStr("John"),
    "lastName" -> JStr("Smith"),
    "address" -> JObj(Map(
      "streetAddress" -> JStr("21 2nd street"),
      "state" -> JStr("NY"),
      "postalCode" -> JNum(10021)
    )),
    "phoneNumbers" -> JSeq(List(
      JObj(
        Map("type" -> JStr("home"), "number" -> JStr("212 555-1234"))
      ),
      JObj(
        Map("type" -> JStr("fax"), "number" -> JStr("646 555-4567"))
      )
    ))
  ))

  type JBindings = (String, JSON)


  def show(json: JSON): String = json match {
    case JSeq(elems) => "[" + (elems map show mkString ", ") + "]"
    case JObj(bindings) => val assocs = bindings map {
      case (key, value) => "\"" + key + "\": " + show(value)
    }
      "{" + (assocs mkString ", ") + "}"

    case JNum(num) => num.toString
    case JStr(str) => '\"' + str + '\"'
    case JBool(b) => b.toString
    case JNull => "null"
  }

  println(show(data))

//  val f =  String => String =   ...
  val f: PartialFunction[String, String] = {
    case "ping" => "pong"
    case "pong" => "ping"
  }

  println(f("ping"))
  println(f("pong"))
  println(f.isDefinedAt("ping"))

}
