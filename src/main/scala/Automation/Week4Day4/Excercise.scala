package Automation.Week4Day4

import org.openqa.selenium.{By, WebDriver, WebElement}
import org.openqa.selenium.chrome.ChromeDriver

object Excercise extends App {
  val driver:WebDriver = new ChromeDriver()
  val url = "https://www.selenium.dev/selenium/web/web-form.html"
  driver.get(url)
  val nameInput:WebElement = driver.findElement(By.id("my-text-id"))
  nameInput.sendKeys(("test@gmail.com"))
  println("name input found: " + "passed")

  val password:WebElement = driver.findElement(By.name("my-password"))
  password.sendKeys(("Password123"))
  println("password found: " + "passed")

  val textarea :WebElement = driver.findElement(By.xpath("//form/div/div/label/textarea"))
  textarea.sendKeys("This is a little comment")
  println("comment found: " + "passed")

  val allInput:java.util.List[WebElement] = driver.findElements(By.tagName("input"))
  println(allInput.size)

  val link:WebElement = driver.findElement(By.linkText("Return to index"))
  link.click()
  println("link clicked")

  driver.navigate().back()
  println("Back to home page")

  val partialLink: WebElement = driver.findElement(By.partialLinkText("Return"))
  partialLink.click()
  driver.quit()
}
