package Revision

import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.{By, JavascriptExecutor, WebDriver}

object HandlingFrame extends App {

  val driver:WebDriver = new ChromeDriver()
  val url = "https://the-internet.herokuapp.com/nested_frames"
  driver.get(url)
  val js = driver.asInstanceOf[JavascriptExecutor]
  val isOnDefaultBefore = js.executeScript("return window.self === window.top").asInstanceOf[Boolean]
  println(s"isOnDefault: $isOnDefaultBefore")
  //cant go into any nested frame directly
  driver.switchTo().frame("frame-top")
  println("Frame-top found")
  val isOnDefaultAfter= js.executeScript("return window.self === window.top").asInstanceOf[Boolean]
  println(s"isOnDefault: $isOnDefaultAfter")
  driver.switchTo().frame("frame-middle")
  println("Current Frame: " + driver.findElement(By.tagName("body")).getText)
  driver.switchTo().defaultContent()
  val isOnDefaultFinal = js.executeScript("return window.self === window.top").asInstanceOf[Boolean]
  println(s"isOnDefaultFinal: ${isOnDefaultFinal}")
  driver.switchTo().frame("frame-bottom")
  println("Current Frame: " + driver.findElement(By.tagName("body")).getText)


//  driver.switchTo().frame("frame-top")
//  driver.switchTo().frame("frame-middle")
//  val middleText = driver.findElement(By.id("content")).getText
//  println("Middle Text: " + middleText)
//  driver.switchTo().defaultContent()
//  driver.switchTo().frame(1)
//  val bottomText = driver.findElement(By.tagName("body")).getText
//  println("Bottom Text = " + "bottomText")
//
//  driver.switchTo().defaultContent()
//
//  val frameTop = driver.findElement((By.name("frame-top")))
//  driver.switchTo().frame(frameTop)
//  driver.switchTo().frame("frame-left")
//  val leftText = driver.findElement(By.tagName("body")).getText
//  println("left text = " + leftText)
driver.quit()
}
