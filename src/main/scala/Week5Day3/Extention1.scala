package Week5Day3

import org.openqa.selenium.{By, WebDriver}
import org.openqa.selenium.chrome.ChromeDriver

object Extention1 extends App {

  //1. Handle Alerts:
  //• Go to this URL: https://www.tutorialspoint.com/selenium/practice/alerts.php
  //• Trigger and accept a simple alert.
  //• Trigger and dismiss a confirm alert.
  //• Trigger a prompt alert, enter text, and accept.
  val driver:WebDriver = new ChromeDriver()
  val url: String = "https://www.tutorialspoint.com/selenium/practice/alerts.php"
  driver.navigate().to(url)
 driver.findElement(By.xpath("/html/body/main/div/div/div[2]/div[1]/button")).click()
  val simpleAlert = driver.switchTo().alert()
  println("Alert text:" + simpleAlert.getText)
  simpleAlert.accept()

  driver.findElement(By.xpath("/html/body/main/div/div/div[2]/div[3]/button")).click()
  val confirmAlert = driver.switchTo().alert()
  println("Confirm alert text: " + confirmAlert.getText)
  confirmAlert.dismiss()
  println("Confirm alert dismissed")

  driver.findElement(By.xpath("/html/body/main/div/div/div[2]/div[4]/button")).click()
  val promptAlert = driver.switchTo().alert()
  promptAlert.sendKeys("Tester")
  println("Prompt alert text: " + promptAlert.getText)
  promptAlert.accept()

 driver.quit()


}
