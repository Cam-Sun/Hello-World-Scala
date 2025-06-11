package Week5Day3

import org.openqa.selenium.{By, WebDriver}
import org.openqa.selenium.chrome.ChromeDriver

object HandlingAlerts extends App {
  val driver:WebDriver = new ChromeDriver()
  val url = "https://the-internet.herokuapp.com/javascript_alerts"
  driver.get(url)
  driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[1]/button")).click()
  driver.switchTo().alert().accept()
  println("Test passed for simple alert")

  //confirmation alert code
  driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[2]/button")).click()
  driver.switchTo().alert().dismiss()


  //promp alert code
  driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[3]/button")).click()
  driver.switchTo().alert()

 driver.quit()
}
