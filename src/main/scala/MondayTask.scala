object MondayTask extends App {

  val taskOne= () => {
  val evaluation1:Boolean = (3 + 4) *57 < 300
    val evaluation2:Boolean = (100 + 40 )/ 12 >= 12
    val evaluation3: Boolean = "Cat" <= "Dog"
    val evaluation4:Boolean = "Rabbit"< "Hamster"
    val evaluation5:Boolean = 12 %2== 0
    val evaluation6:Boolean = (74 /9)<30  && (89/6)<20

    println (evaluation1)
    println (evaluation2)

    println (evaluation3)
    println (evaluation4)
    println(evaluation5)
    println(evaluation6)
}
  taskOne()

  /* 2. What is the difference between the `String` “I love scala already” and the print line “println (“I
  love scala already”)” ? */


  /* 3. Write a method to calculate the square of an `Int`. It should have an `Int` input parameter and
`Int` return type.*/
  def calculateSquare(num:Int):Int ={
  num * num
  }
  println(calculateSquare(4))

  /* 4. Write a method to check if a number is odd. It should have an `Int` input parameter and
`Boolean` return type.*/

  def checkOddNumbers(num:Int):Boolean={
    val isOddNumber: Boolean = num % 2 != 0
    isOddNumber
  }

  println("check odd numbers:" + checkOddNumbers(8))


  class Book (val category:String, val title:String, val author:String, val price: Double, val available:Boolean, var liked :Int = 0) {

    def countLikes ():Int ={
     liked += 1
      liked
    }
  }
  val book1 = new Book("Fiction", "The great gatsby", "F. Scott Fitzgerald", 10.33, true, 0)
  book1.countLikes()
  book1.countLikes()
  println(s"The book ${book1.title} has been liked ${book1.liked} times")



//Extention 1
  val stringLowerCase: String = "am a lower case string"
  val stringUpperCase: String = stringLowerCase.toUpperCase
  println("Extention1: " + stringUpperCase)
  println("Extention1: " +  stringLowerCase)

  //Extention 2 does capitalize mutate the original string?
  println("Extention2: " + stringLowerCase.capitalize)

  //Extention 3
  println("Extention3: ")
  val isEqual = "string" == "STRING"
  println( isEqual)

  //Extention 6
  println("Extention4: ")
  val stringOne = "1"
  println(stringOne.toInt)

  //Extention 6
  def convertIntToString(num:Int):String = {
    val numToString : String = num.toString
    println(s"The data type of $num is ${numToString.getClass.toString}")
    numToString
  }
 println(convertIntToString(5))
}

