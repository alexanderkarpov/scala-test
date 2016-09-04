//import books.odersky.chapter4.ChecksumAccumulator
//
//val acc = new ChecksumAccumulator
//val csa = ChecksumAccumulator

//acc.equals(csa)

val x = ~(0xFFFFFFF0)

printf("%X\n", x)

val s = """preved \n medved"""
val s1 = """Welcome to Ultamix 3000.
           |Type "HELP" for help.""" stripMargin

println (s1)

val symbol = Symbol("preved")

symbol.name

s indexOf "\\"
s1 indexOf "\n"
s1 indexOf "Type"
s1 indexOf "ZZ"

s indexOf ("ve", 4)

//The only identifiers that can be used as prefix operators are + , - , ! , and ~
(2.0).unary_-
-2.0

s1 toLowerCase


//a ::: b ::: c is treated as a ::: (b ::: c) . But a * b * c , by contrast, is
//treated as (a * b) * c .


//Some rich operations
0 max 5
0 min 5
-2.7 abs;
-2.7 round;
1.5 isInfinity;
(1.5 / 0) isInfinity;
4 to 6
"bob" capitalize;
"robert" drop 2
