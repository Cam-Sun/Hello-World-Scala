package Week6Day1

import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.{ChromeDriver, ChromeOptions}

object HeadlessMode extends App {
 val options = new ChromeOptions()

  options.addArguments("headless")

  //Instantiating the ChromeDriver for interacting with the Chrome browser
  val driver:WebDriver = new ChromeDriver(options)

  //Accessing the web url for testing
  driver.get("")
}
