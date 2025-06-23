package Week6Day1

import org.openqa.selenium.chrome.{ChromeDriver, ChromeOptions}
import org.openqa.selenium.io.FileHandler
import org.openqa.selenium.support.ui.{ExpectedConditions, WebDriverWait}
import org.openqa.selenium.{By, ElementNotInteractableException, OutputType, TakesScreenshot, TimeoutException, WebDriver}

import java.io.File
import java.nio.file.{Files, Path, Paths}
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
  options.addArguments("--headless=new")
  println("options add arguments: " + options)
  val driver = new ChromeDriver()
  val basePath: String = "/Users/camille.sun/Documents/scrFull/TaskTestResult/W6d1"

  def makeScrenshort(driver: WebDriver, prefix: String = "", basePath: String = Task.basePath) {
    val timestamp = new SimpleDateFormat("YYYY-MM-DD").format(new Date())
    val srcTimestamp: File = driver.asInstanceOf[TakesScreenshot].getScreenshotAs(OutputType.FILE)
    FileHandler.copy(srcTimestamp, new File(s"$basePath/$prefix-$timestamp.png"))
  }

  try {
    driver.get("https://the-internet.herokuapp.com/login")

    //Enter log in info and click log in
    driver.findElement(By.id("username")).sendKeys("tomsmith")
    driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!")
    //Unhappy path wrong password
    //driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!")
    driver.findElement(By.cssSelector("button[type='submit']")).click()

    val explictWait = new WebDriverWait(driver, Duration.ofSeconds(3))
    explictWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("flash")))

    val currentUrl = driver.getCurrentUrl
    println("Current URL:" + currentUrl)

    val screenShotsFolder: Path = Paths.get(basePath)
    if (Files.notExists(screenShotsFolder)) {
      println("here")
      Files.createDirectories(screenShotsFolder)
      println("Folder created")
    }
    val className = driver.findElement(By.id("flash")).getAttribute("class")
    if (className.contains("error")) {
      makeScrenshort(driver, "failure", basePath)
    } else makeScrenshort(driver, "succeed", basePath)


  } catch {
    case e: NoSuchElementException => e.getStackTrace
    case e: TimeoutException => e.getStackTrace
    case e: ElementNotInteractableException => e.getStackTrace

  } finally driver.quit()

}
