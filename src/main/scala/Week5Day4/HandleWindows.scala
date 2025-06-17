package Week5Day4

import org.openqa.selenium.{By, WebDriver}
import org.openqa.selenium.chrome.ChromeDriver

import scala.jdk.CollectionConverters.CollectionHasAsScala

object HandleWindows extends App {
val driver:WebDriver = new ChromeDriver()
  driver.get("https://the-internet.herokuapp.com/windows")
  driver.manage().window().maximize()

  // Returns current windows'UNIQUE ID
  val parentWindow = driver.getWindowHandle()
  println("Handle for the parent window: " + parentWindow)

  driver.findElement(By.linkText("Click Here")).click()

  val allWindows:List[String] = driver.getWindowHandles.asScala.toList
  println("All windows:" + allWindows)
  val it = allWindows.iterator

  while(it.hasNext){
    println("How the iterator looks like on demand!" +it)
    val handle = it.next()
    println("handle" +handle)
    if(handle!= parentWindow){
      driver.switchTo().window(handle)
      println("\n")
      println(s"Is current handle the parentWindow: ${handle == parentWindow} " )
      println("The page title is :" + driver.getTitle)
    } else println("The Iterator is currently on parentWindow element")
  }

}
