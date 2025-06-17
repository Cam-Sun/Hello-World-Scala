package Week6Day1

import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver

object Exceptions extends App {

  val driver: WebDriver = new ChromeDriver()
  try{
  driver.get("https://www.selenium.dev/selenium/web/web-formdajf.html")
//  driver.findElement(By.id("nonexistent-id")).click()
  } catch{
//    case e:NoSuchElementException =>
//      e.printStackTrace()
    case e:Exception =>
      println("Print any exception")
      e.printStackTrace()
  }
  finally{
    if(driver != null){
      driver.quit()
    }
  }

}
