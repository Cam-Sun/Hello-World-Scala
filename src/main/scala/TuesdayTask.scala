object TuesdayTask extends App {

  /*
  1. Create a `Seq` of taxpayer forenames representing multiple submissions, including  some duplicates. Store this `Seq` in a val.
   */
  val taxPayerForenames : Seq[String] = Seq("Jack", "Lily", "James", "Nick", "Jack", "Jack", "Nick", "Ana")

//  Using string interpolation, print the full list of submissions.
  // intended to practice string interpolation or any method?
  println(s"The tax payer ${taxPayerForenames}")

  /*
  3. Write a method that uses the built-in method `.count` to identify how many times a
specific taxpayer submitted their tax returns in the `Seq` from question 1. This method
should work for any inputted taxpayer.
   */
  def countSubmissionsByName(inputName:String):Int = taxPayerForenames.count(name => name.toUpperCase ==inputName.toUpperCase)
  val timesOfJack : Int = countSubmissionsByName(("jack"))
  println(timesOfJack)
  /*
  4. Print a sentence that states how many times a specific person submitted their tax
returns using your method for question 3.
   */
  println(s"Jack has submitted $timesOfJack times")
  println(s"Nick has submitted ${countSubmissionsByName("Nick")} times")

  /*
  5. Using a built-in method (research will be required here), convert the `Seq` to a `Set` to
remove duplicates.
   */
  val uniqueTaxpayerNames = taxPayerForenames.toSet
  println("uniqueTaxpayerNames:" + uniqueTaxpayerNames)

/*
6. Using string interpolation, print the list of unique taxpayers who submitted.
 */
  println(s"The taxpayers are $uniqueTaxpayerNames")

  /*
  7. Refactor your method from question 3 to work for any inputted collection (HINT: look
back at the collection family tree in the PowerPoint).
   */
def countSubmissionByNameForAllCollection  (inputCollection: Iterable[String], inputName: String ) = {
  inputCollection.count(name => name.toUpperCase == inputName.toUpperCase)
}
  /*
  8. Using your method from question 7, print the count of the same taxpayer in both the
`Seq` from question 1 and the `Set` from question 5.
   */
  val timesOfJackFromSet = countSubmissionByNameForAllCollection(uniqueTaxpayerNames, "Jack")
  println("timesOfJackFromSet:" + timesOfJackFromSet)

  /*
  9. Imagine that the user of this service needs to login however there are 6 users that have
failed login attempts.
   */
/*
a. Write a Map[String, Int] to represent the number of failed attempts for each
user.
 */
  //a. Write a Map[String, Int] to represent the number of failed attempts for each user.
  val failedLoginlLog : scala.collection.mutable.Map[String,Int] = scala.collection.mutable.Map (
    "Lily" -> 1,
    "Nick" -> 2,
    "Jack" -> 3,
    "James" ->1,
    "Nancy" -> 2
  )

  println("keys keys" + failedLoginlLog.keys)
  println("keys keys list"  + failedLoginlLog.keys.toList)
  //b. Print the number of failed attempts for the user at index position 0.
println(failedLoginlLog("Lily"))

  // c. Add a new user to your Map who has 3 failed attempts.
failedLoginlLog("Jay") = 3
  println(failedLoginlLog)

  //d. Update the user at index position 1 to have a further failed attempt.
failedLoginlLog("Nick") +=1
  println(failedLoginlLog("Nick"))

  //e. Remove the user at index position 5.
  failedLoginlLog -= ("Lily")
  println(failedLoginlLog)

  //Extentions
/*
1. Write two `Sets` that detail submissions on day 1 and day 2. (You can use your `Set` from
question 5 if you want!)
 */

  val day1Submitters:Set[String] = Set("Mandy","Alex", "Wendy", "Susie", "Jack", "Anto", "Marco", "Lucy")
  val day2Submitters:Set[String] = Set("Joseph", "Nick", "Lily", "Max", "Alex", "Thomas", "Mandy")
  val combinedUniqueSubmitters= day2Submitters.union(day1Submitters)
  println("combinedUniqueSubmitters: " + combinedUniqueSubmitters)
  val onlyDay1Submiiters = day1Submitters.diff(day2Submitters)
  println("Submitted Only on Day 1: " + onlyDay1Submiiters)
  val bothDaysSubmitters = day1Submitters.intersect(day2Submitters)
  println("Submitted on both days: " + bothDaysSubmitters)

  //Research

}
