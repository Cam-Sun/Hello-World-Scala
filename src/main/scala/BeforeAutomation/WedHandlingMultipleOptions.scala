package BeforeAutomation

object WedHandlingMultipleOptions extends App{
val weather:String = "sunny"
  //IF ELSE statement
  if(weather == "rainy"){
    println("Take a coat with a hood")

    // you can have as many else/if as you need
  } else if (weather == "sunny"){
    println("Wear sun cream")
  } else if (weather == "cold"){
    println("Wear a warm coat")
  } else {
    println("not a valid weather option")
  }

  val season: String = "winter"
  // How we approach this when we have multiple options:
  if (weather == "cold" || season =="winter"){
    println("take a coat")
  } else {
    println("A light jacket fine")
  }

  // PATTERN MATCH
  weather match{
    case "rainy" => println("take a coat with a hood")
    case "sunny" => println("wear sun cream")
    case "cold" => println("wear a warm coat")
    case _ => println("not a valid weather option")
  }

  (weather, season) match {
    case (weather, season) if weather == "cold" || season == "winter" => println ("take a coat")

    case _ => println("A light jacket fine")
  }

  // INT - slightly more careful
 val age:Int = 6
//  if(age <= 0) println("Invalid input")
//  if(age >= 18) println(s"You are an adult because you are $age")
//  else println(s"You are a child because you are $age")

//  age match{
//    case age if age <= 0 => println("Invalid input")
//    case age if age >=18 => println(s"You are an adult because you are $age")
//    case _ => println(s"You are a child because you are $age")
//  }

  // how to write in percentage and how to compare percentage number
 val grade :Double = 0.8
  var response: String = ""

  if(grade >= 0.9) response = "A"
  else if (grade >= 0.8 & grade <0.9) response = "B"
  else if (grade >=0.7 & grade <0.8) response = "C"
  else if(grade >=0.6 & grade < 0.7) response = "D"
  else if(grade >=0.5 & grade < 0.6) response = "E"
  else response = "F"
  println(response)

  age match{
    case age if age >= 4 => println("You can watch U rating film")
  }


  // OPTIONS (getOrElse)

  val name : Option[String] = Some("April")
  val emptyName: Option[String] = None

 println("name:" + name)
  println("emptyName:" + emptyName)

    def getName(name:Option[String]):String = name.getOrElse("This user has left the field empty")
  println("get name: " + getName(name))
  println("get empty name:" + getName(emptyName))


  // Try ~Catch block

  //diving by zero, vonverting strings to numbers, accesssing files, dealing with bad input from a suer or system

  try{
    //Code that might fail
    //All Logic - If/else, patter match, def, val
    val number = "123".toInt
    println(s"the number is $number")
  } catch{
    case error: NumberFormatException => println(s"$error was not a valid input") // often see error as e
  }








}
