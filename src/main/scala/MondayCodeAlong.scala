object MondayCodeAlong extends App {
    val melons = 5 * 50
    val apples = 2 * 10
    val fizzyDrink = 6 * (100 * 1.20)
  //  val total = melons + apples + fizzyDrink

  //VAR mutable
  var total: Double = 0
  println("plus apples:" +(total + apples))
  println(total + melons)

//  println(fizzyDrink)
//  println(total)

  //TYPES

  val wholeNumber:Int = 6483
  val littleNumber:Short = 68
  val bigNumber:Long = 9750
  val falseBoolean:Boolean  = false
  val trueBoolean:Boolean = true
  println(falseBoolean == trueBoolean)


  //OPERATOR

  val a:Int = 10
  val b:Int = 4
  val c:Int = 5
  val add:Int = a + b


  //LOGICAL
  val not:Boolean = !false
  println(not)


  // MEHTODS
  def  makeACupOfTea(sugar: Int, milk:Boolean):String = {
    s"You have made a cup of tea with $sugar spoons of sugar. Your milk selection is:$milk"
  }

  println(makeACupOfTea(4,milk = true))


  val vat:Double = 1.2
  def getFinalPrice(productPrice: Double, vat: Double): String = {
    val finalPrice = productPrice * (1 + 0.2)
//    finalPrice
  s"The product final price is $finalPrice"
  }

  println(getFinalPrice(5.58, 1.2))

  //CLASSES ( think of these as a type)
  //THIS IS MY INSTRUCTION
  class Dog(val name:String, val age:Int, val likesBanans:Boolean) {
    def speak:String ="woof"
  }

}


