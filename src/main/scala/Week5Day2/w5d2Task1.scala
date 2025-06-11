package Week5Day2

import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver

object w5d2Task1 extends App {
  //Task1
  val url:String = "https://demoqa.com/browser-windows"
  //1. Launch the browser using WebDriver.
  val driver: WebDriver = new ChromeDriver()
  //2. Navigate to the test URL.
  driver.navigate().to(url)
  //3.1 Fetch and print Page title
  val pageTitle: String = driver.getTitle
  println(f"Page title: $pageTitle")
  //3.2 Fetch and print Current URL
  val currentUrl:String = driver.getCurrentUrl
  println(f"Current url: $currentUrl")
  driver.close()
  driver.quit()
}
