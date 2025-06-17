package Week6Day1

import org.openqa.selenium.chrome.{ChromeDriver, ChromeOptions}
import org.openqa.selenium.io.FileHandler
import org.openqa.selenium.support.ui.{ExpectedConditions, WebDriverWait}
import org.openqa.selenium.{By, ElementNotInteractableException, OutputType, TakesScreenshot, TimeoutException, WebElement}

import java.io.File
import java.text.SimpleDateFormat
import java.time.Duration
import java.util.Date

object Task extends App {
/*
Automate the following scenario:
Headless Login with Screenshot Capture and exception handling.
1. Use ChromeDriver with `--headless=new option`
2. Navigate to the login URL - https://the-internet.herokuapp.com/login
a. Username: tomsmith
b. Password: SuperSecretPassword!
3. Submit the login form.
4. Wait for the result message (success or failure).
5. Take a screenshot [Wrap key steps in a utility function that takes a screenshot].
6. Save as screenshots/YYYY-MM-DD-success-<timestamp>.png or screenshots/YYYY-MMDD-
failure-<timestamp>.png
7. Use try / catch / finally:
a. catch Selenium exceptions (e.g., NoSuchElementException, TimeoutException)
8. Finally, call driver.quit().
 */

  val options: ChromeOptions = new ChromeOptions()
  println("naked options: " + options)
  options.addArguments("headless")
  println("options add arguments: " + options)
  val driver = new ChromeDriver()

  def takeScrenshort (outcome:String) {
    val timestamp = new SimpleDateFormat("YYYY-MM-DD").format(new Date())
    val srcTimestamp: File = driver.asInstanceOf[TakesScreenshot].getScreenshotAs(OutputType.FILE)
    FileHandler.copy(srcTimestamp, new File(s"/Users/camille.sun/Documents/scrFull/TaskTestResult-$outcome-$timestamp.png"))
  }

  try{

  driver.get("https://the-internet.herokuapp.com/login")

  //Enter log in info and click log in
  val userNameInput:WebElement = driver.findElement(By.id ("username"))
  userNameInput.sendKeys("tomsmith")
  val passwordInput:WebElement = driver.findElement(By.id("password"))
  passwordInput.sendKeys("SuperSecretPassword!")
  val login:WebElement = driver.findElement(By.cssSelector("button[type='submit']"))
  login.click()


    val explictWait = new WebDriverWait(driver, Duration.ofSeconds(3))
    explictWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("flash")))

  val currentUrl = driver.getCurrentUrl
  println("Current URL:" + currentUrl)

  val className = driver.findElement(By.id("flash")).getAttribute("class")
  if (className.contains("error")){
    takeScrenshort("failure")
  } else takeScrenshort("succeed")

}catch{
  case e :NoSuchElementException => e.getStackTrace
  case e: TimeoutException => e.getStackTrace
  case e: ElementNotInteractableException => e.getStackTrace

  } finally driver.quit()

}
