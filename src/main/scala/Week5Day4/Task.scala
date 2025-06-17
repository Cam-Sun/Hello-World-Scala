package Week5Day4

import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.support.ui.WebDriverWait
import org.openqa.selenium.{By, JavascriptExecutor, WebElement}

import java.time.Duration
import scala.jdk.CollectionConverters.CollectionHasAsScala

object Task extends App {

  /*
2. Static Table Handling
• Locate the table containing country data.
• Extract and print all country names from the first column.
• Use JavaScript Executor to highlight each row as it’s read.
  */
  val driver = new ChromeDriver()
  driver.get("https://cosmocode.io/automation-practice-webtable/")
  val table: WebElement = driver.findElement(By.id("countries"))
  val rows = driver.findElements(By.tagName("tr")).asScala.toList
  val nakedRows = driver.findElements(By.tagName("tr"))
  println("nakedRows: "+ nakedRows.get(1).getText)

  println("Rows size: " + rows.size)
  println(rows(1).getText) // get all text in row 1

  val js = driver.asInstanceOf[JavascriptExecutor]

//  val nonTitleRows = rows.drop(1)
//  nonTitleRows.foreach(row=>{
//  val nonTitleCells = row.findElements(By.tagName("td")).asScala.toList
//  println(nonTitleCells(1).getText)
//    var script = "arguments[0].style.color='#ca0808'"
//    js.executeScript(script,row)
//  })

  for(i<-1 until rows.size){
    val cells = rows(i).findElements(By.tagName("td")).asScala.toList
    println(f"1st column row $i: " + cells(1).getText)
   js.executeScript("arguments[0].style.color='#0693e3'; arguments[0].style.backgroundColor ='rgb(217 132 73)'; arguments[0].style.border", rows(i))
  }


//val javaRows = driver.findElements(By.tagName("tr"))
//  for((row,index) <- javaRows.asScala.zipWithIndex){
//    val cells = row.findElements(By.tagName("td"))
//    println(cells.asScala.map(_.getText()))
//  }


  /*
  3. Implicit Wait
• Set a global implicit wait of 10 seconds.
   */

  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10))


  /*
  4. Explicit Wait
• Wait for a specific country row (e.g., "Germany") to be visible.
• Once visible, extract its capital and currency.
   */
val explicitWait = new WebDriverWait(driver, Duration.ofMinutes(1))
val germanyRow = rows.find(row => row.getText().contains("Germany"))
  println("germanyRow: " + germanyRow)


//1. JavaScript Executor
  //• Scroll to the bottom of the page using JavaScript.
  //• Change the background colour of the "Country" column header.
  //• Retrieve and print the page title using JavaScript.

  js.executeScript("window.scrollBy(0,document.body.scrollHeight)")
  Thread.sleep(1500)
  js.executeScript("window.scrollBy(0,-1650)","")
  Thread.sleep(2000)
  val CountryColumnHeader = driver.findElement(By.cssSelector("#countries > tbody > tr:nth-child(1) > td:nth-child(2) > h3 > strong"))
  js.executeScript("arguments[0].style.backgroundColor='green'",CountryColumnHeader)
  js.executeScript("arguments[0].scrollIntoView();",CountryColumnHeader)
  val pageTitle = js.executeScript("return document.title").toString
  println("pageTitle: " + pageTitle)
//
//  val words = List("one", "two", "three", "four")
//  val wordsZippedWithIndex = words.zipWithIndex
//  println(words)



}
