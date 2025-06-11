package Week5Day3

import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.{By, WebDriver}

object Extention2NestedFrames extends App {
  //• Go to this URL: https://www.tutorialspoint.com/selenium/practice/nestedframes.php
  //• Switch to a frame that is nested and access content inside it.
  val driver:WebDriver = new ChromeDriver()
  val url: String = "https://www.tutorialspoint.com/selenium/practice/nestedframes.php"
  driver.navigate().to(url)
  driver.manage().window().maximize()
  val frame = driver.findElement(By.tagName("iframe"))
  driver.switchTo().frame(0)
  println("Frame index 0")
  driver.switchTo().defaultContent()
 // frame index above 1 is not found. seems like there is a single frame
 driver.quit()
}
