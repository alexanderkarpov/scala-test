object lists {
  1 :: List(2, 3, 4)
  List(2, 3, 4).::(1)

  val thrill = "Will" :: "fill" :: "until" :: Nil

  List("a", "b") ::: List("c", "d")

  thrill(2)

  thrill.count(p => p.length == 4)

  thrill.drop(2)

  thrill.dropRight(2)

  thrill.exists(s => s == "fill")

  thrill.filter(s => s.length == 4)

  thrill.forall(s => s.endsWith("l"))

  thrill.foreach(println)

  thrill.head

  thrill.tail

  thrill.last

  thrill.init

  thrill.map(s => s + "y")

  //  thrill.remove(s => s.length == 4)

  thrill.reverse

  thrill.sortWith((x, y) => x.charAt(0).toLower < y.charAt(1).toLower)


}