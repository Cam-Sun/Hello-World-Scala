import WedHandlingMultipleOptions.age

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
  if(age <= 0) println("Invalid input")
  if(age >= 18) println(s"You are an adult because you are $age")
  else println(s"You are a child because you are $age")

  age match{
    case age if age <= 0 => println("Invalid input")
    case age if age >=18 => println(s"You are an adult because you are $age")
    case _ => println(s"You are a child because you are $age")
  }











}
