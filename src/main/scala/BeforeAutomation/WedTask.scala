package BeforeAutomation

object WedTask extends App {
/*
John from primary school maths is trying to buy as many watermelons as possible and we need to
give him a reality check. John can reasonably carry 3 watermelons without a bag, and 5 with one
bag.
a) Create a value to store a number of watermelons.
b) Use your Scala knowledge to print appropriate messages based on the criteria above to tell
John whether he:
i. Doesn't need a bag
ii. Needs a bag
iii. Can't carry them
Be sure to consider how you will handle invalid numbers.
c) Use string interpolation to add to each message the number of watermelons John is trying to
buy.
d) Create a value to store a `Boolean` that indicates whether John has a bag with him or not.
e) Use an if/else statement and this `Boolean` value to tell John whether he can or cannot by the
desired number of watermelons in Task 1.
 */

val totalWatermelons: Int = 7
val hasOneBag:Boolean = false

  if(totalWatermelons <0){
    println(s"The number is $totalWatermelons. Invalid input.")
  } else if (totalWatermelons == 0){
    println(s"The number is $totalWatermelons. Sorry John. Are you sure you don't wanna any watermelon")

  } else if(totalWatermelons > 0 & totalWatermelons <=3){
    println(s"The number is $totalWatermelons. Hey John, you can carry all of them without any bag")

  } else if (totalWatermelons >=5 & hasOneBag == false){
    println(s"The number is $totalWatermelons. Hey John The maximum can buy is 3 if you have no bag with you.")
  } else if( totalWatermelons ==5 & hasOneBag == true) {
    println(s"The number is $totalWatermelons. Hey John, you can buy a bag of watermelon ")
  } else {
    println(s"The number is $totalWatermelons. Hey John, It is getting really heavy. you can fit 5 into your bag. ")
  }



/*
A person is paid £0.45 per mile travelled. When they input their miles travelled it goes in as a
`String` (e.g. “twenty”). Given the distance inputted, calculate the amount to be paid back being
sure to use try/catch to account for errors.
 */

  val inputMiles:String = "twenty"
  try{
    val payment = String.format("%.2f", inputMiles.toInt * 0.45)
    println(s"We will be paid $payment to your account")
  } catch{
    case error: NumberFormatException => println(s"$error was not a valid input")
  }

  /*
  Extension:
Logical operators used in IF statements (e.g., && or <) have an order of precedence.
1. What is this order, where can we find it?
Let's try to apply it, try to predict the answer before coding it: */

  // && has higher precedence than ||

// 2. What would (true || false && false) result in?

println(true || false && false)

// 3. What about ((true || false) && false)? (Note the parentheses used here.)

 // regardless of the result in parentheses, && false is false

  println((true || false) && false)
// 4.And finally, how about (1 < 4 && 7 != 10 || 9 + 10 == 21)?
// ANSWER same as true || false => result in true
  println(1 < 4 && 7 != 10 || 9 + 10 == 21)


  /*
Research:
If statements always return values. This means we can assign values based on if statements.
How would we go about doing this, or where could we search to find out?
Try out the example below:
1. Create two values that hold integers. Assign any integer you'd like to these values.
2. Create a new value of type `String` and assign it "yes" if the first value is greater than the second,
and "no" if the second value is greater. (Don’t overthink this!)
 */

  val value1: Int = 5
  val value2: Int = 6
  val isBigger :String = if (value1 > value2) "yes" else "no"

  print(isBigger)
}

