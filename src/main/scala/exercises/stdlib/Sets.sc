object Sets {

  /*
  **Set operations** for union, intersection,
  * and set difference. Each of these operations exists
  * in two forms: alphabetic and symbolic.
  * The alphabetic versions are intersect, union, and diff,
  * whereas the symbolic versions are &, |, and &~.
   */

  val mySet1 = Set("Michigan", "Ohio", "Wisconsin", "Iowa")
  val mySet2 = Set("Wisconsin", "Michigan", "Minnesota")
  val aNewSet = mySet1 intersect mySet2
}