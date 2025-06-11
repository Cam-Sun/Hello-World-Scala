package Week5Day3

import org.openqa.selenium.{By, WebDriver, WebElement}
import org.openqa.selenium.chrome.ChromeDriver

object Extention2SingleFrame extends App {
//2. Handle Frames:
  //• Go to this URL: https://www.w3schools.com/html/tryit.asp?filename=tryhtml_iframe
  //• Switch to the frame and interact with the simple content inside it.
  //• Go to this URL: https://www.tutorialspoint.com/selenium/practice/nestedframes.php
  //• Switch to a frame that is nested and access content inside it.

  val driver:WebDriver = new ChromeDriver()
  val url: String = "https://www.w3schools.com/html/tryit.asp?filename=tryhtml_iframe"
  driver.navigate().to(url)
//  driver.manage().window().maximize()
  val frame:WebElement = driver.findElement(By.tagName("iframe"))
  driver.switchTo().frame(frame)
  println("Switched to frame")
//  val h1Text: String = driver.findElement(By.tagName("h1")).getText
//  println("H1 in iframe" + h1Text)
//  driver.switchTo().defaultContent()

 driver.quit()
}
