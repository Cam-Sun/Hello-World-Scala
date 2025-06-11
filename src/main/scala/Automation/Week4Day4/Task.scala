package Automation.Week4Day4

import org.openqa.selenium.{By, WebDriver, WebElement}
import org.openqa.selenium.chrome.ChromeDriver

object Task extends App {
val url = "https://www.w3schools.com/html/html_examples.asp"

  val driver:WebDriver = new ChromeDriver()
  driver.get(url)

  val allButtonElements = driver.findElements(By.tagName("button"))
  println(allButtonElements.size)

  val allImagesElements = driver.findElements(By.tagName("img"))
  println(allImagesElements.size)

  val allH1 = driver.findElements(By.tagName("h1"))
  println(allH1.size)

  driver.quit()
}
