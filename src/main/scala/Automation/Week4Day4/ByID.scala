package Automation.Week4Day4

import org.openqa.selenium.{By, WebDriver, WebElement}
import org.openqa.selenium.chrome.ChromeDriver

case object ByID extends App{
  //Instantiating the ChromeDriver for interacting with the Chrome browser
  val driver:WebDriver = new ChromeDriver()
  //Accessing the web url for testing
  driver.get("https://proleed.academy/exercises/selenium/selenium-element-id-locators-practice-form.php")
val emailAddresse: WebElement = driver.findElement(By.id("email"))
  emailAddresse.sendKeys(("test@gmail.com"))
  println(("Email entered - Passed"))
  val password:WebElement = driver.findElement(By.id("password"))
  password.sendKeys(("Password123"))
  println(("Password entered - Passed"))
  val login:WebElement = driver.findElement(By.id("login"))
  login.click()
  println(("Login clicked - Passed"))
  driver.quit()
}
