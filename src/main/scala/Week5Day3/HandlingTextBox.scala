package Week5Day3

import org.openqa.selenium.{By, WebDriver}
import org.openqa.selenium.chrome.ChromeDriver

object HandlingTextBox extends App {
val driver:WebDriver = new ChromeDriver()
val url = "https://www.selenium.dev/selenium/web/web-form.html"
  driver.navigate().to(url)
  val text = driver.findElement(By.id("my-text-id"))
  text.sendKeys("Welcome to Mercator")
  val textValue =  text.getAttribute("value")
  println(textValue)
}
