package BeforeAutomation

object TueCollectionCodeAlong extends App {

  val firstSet :Set[Int] = Set(1,2,3,4,5, 6)
  println(firstSet)
  println(firstSet)

  val firstSeq:Seq[Int] = Seq(1, 2, 3, 4, 5, 5)
  println("firstSeq:" + (firstSeq))
//  val firstSeq

  //Keys must be unique. We cant have two keys that are the same.
  val firstMap:Map[String, Int] = Map(
    "one" -> 1,
  "two" -> 2,
  "three" -> 3,
    "three" -> 3,
    "four" ->4,
    "five" -> 5

  )

  println(firstMap)

  //Accessing data
  //Sequence Set
  val getSeqHead:Int=firstSeq.head
  val getSeqIndexZero:Int = firstSeq(0)
  println("getSeqHead: " + getSeqHead)
  println("getSeqIndexZero: " + getSeqIndexZero)

  val getSeqTail : Seq[Int] = firstSeq.tail
  println("Seq Tail: " + getSeqTail)

  val getSeqIndex : Int = firstSeq(5)
  println("Seq Index of 5: " + getSeqIndex)



  //Map
  //Sequence Set
  val getMapValue :Int = firstMap("one") //Enter the key to get the value
  println("getMapValue: " + getMapValue)
//  val getMapKey : String = firstMap.find(_.)

//Task 1

  val seqNames : Seq[String] = Seq("Ana", "Bob", "Cecilia")
  println("seqNames:" + seqNames)

  val colorMap :Map[Int, String] = Map(
    1->"red",
    2->"yellow",
    3->"blue",
    4->"green"
  )
  println("colorMap:" + colorMap)

  val blue = colorMap.find(_._2 == "blue").get._1
  println("blue: " + blue)

  val filterMapByBlue = colorMap.filter(num=>num._2 == "blue")
  println("filterMapByBlue: " + filterMapByBlue)

  val intSet :Set[Int] = Set(1, 2, 33, 0, 4)
  val higherThan2 = intSet.filter(_ >2 )
  println("higherThan2 : " + higherThan2)


  //task 2
  //Add 1 to all

  def addOne(inputSeq: Seq[Int]): Seq[Int] = inputSeq.map{
    number => number + 1
  }
  print("Add one :" + addOne(firstSeq))


def checkIfLetterRExists (inputSeq: Seq[String]):Boolean = inputSeq.exists(word => word.contains("R"))

  println((checkIfLetterRExists(seqNames)))


  def evenNumSet(inputSet : Set[Int]):Set[Int] = inputSet.filter {
    number => number % 2 == 0
  }

  println(evenNumSet(firstSet))





}
