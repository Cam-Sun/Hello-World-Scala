package Week5Day3

import org.openqa.selenium.{By, WebDriver, WebElement}
import org.openqa.selenium.chrome.ChromeDriver

object HandlingButtonAndLinks extends App {
  val driver:WebDriver = new ChromeDriver()
  val url = "https://www.selenium.dev/selenium/web/web-form.html"
  driver.get(url)
  val button:WebElement = driver.findElement(By.cssSelector("[type=\'submit\']"))
  val btnText = button.getText
  println(btnText)

  

}
