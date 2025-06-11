package Week5Day2

import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver

object w5d2Task2 extends App {
  //Task2
  val url:String = "https://demoqa.com/automation-practice-form"
  //1. Launch the browser using WebDriver.
  val driver: WebDriver = new ChromeDriver()
  //2. Navigate to the test URL
  driver.navigate().to(url)
  println("Navigate to the test URL")
  //3.1 Navigate to  "https://example.com"
  driver.navigate().to("https://example.com")
  println("Navigate to example.com")
  //3.2 Navigate back
  driver.navigate().back()
  println("Back to test URL")
  //3.3 Navigate forward
  driver.navigate().forward()
  println("Move to previous page")
  //3.4 Refresh the page
  driver.navigate().refresh()
  println("Refresh the current page")
  //4. Using built in methods, maximise and minimise the browser window.
  driver.manage().window().maximize()
  println("Window is maximized")
  driver.manage().window().minimize()
  println("Window is minimized")
  //5. Print part of the page source.
  val pageResource: String = driver.getPageSource
  println(pageResource.take(200))
  //6. Close current window
  driver.close()
  //7. End the session.
  driver.quit()

}
