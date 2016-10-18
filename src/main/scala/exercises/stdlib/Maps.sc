object Maps {
  val myMap = Map("MI" → "Michigan", "OH" → "Ohio", "WI" → "Wisconsin", "IA" → "Iowa")
  val aNewMap = myMap - ("MI", "WI") // Notice: single '-' operator for tuples

  val myMap1 = Map("MI" → "Michigan", "OH" → "Ohio", "WI" → "Wisconsin", "IA" → "Iowa")
  val myMap2 = Map("WI" → "Wisconsin", "MI" → "Michigan", "IA" → "Iowa", "OH" → "Ohio")


  myMap1.equals(myMap2)

  myMap1.values
  myMap2.values

}