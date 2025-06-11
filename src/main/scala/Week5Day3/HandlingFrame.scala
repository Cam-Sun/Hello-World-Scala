package Week5Day3

import org.openqa.selenium.{By, WebDriver}
import org.openqa.selenium.chrome.ChromeDriver

object HandlingFrame extends App {

  val driver:WebDriver = new ChromeDriver()
  val url = "https://the-internet.herokuapp.com/nested_frames"
  driver.get(url)
  driver.switchTo().frame("frame-top")
  driver.switchTo().frame("frame-middle")
  val middleText = driver.findElement(By.id("content")).getText
  println("Middle Text: " + middleText)
  driver.switchTo().defaultContent()
  driver.switchTo().frame(1)
  val bottomText = driver.findElement(By.tagName("body")).getText
  println("Bottom Text = " + "bottomText")

  driver.switchTo().defaultContent()

  val frameTop = driver.findElement((By.name("frame-top")))
  driver.switchTo().frame(frameTop)
  driver.switchTo().frame("frame-left")
  val leftText = driver.findElement(By.tagName("body")).getText
  println("left text = " + leftText)
driver.quit()
}
