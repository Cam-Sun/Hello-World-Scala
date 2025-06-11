package Week5Day3

import org.openqa.selenium.{By, WebDriver, WebElement}
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.support.ui.Select

object HandlingDropDown extends App {
  val driver:WebDriver = new ChromeDriver()
  driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_select")
 driver.switchTo().frame("iframeResult")
  val dropDown: WebElement = driver.findElement(By.name("cars"))

  val select = new Select(dropDown)

  select.selectByVisibleText("Opel")

  select.selectByIndex(3)
  println("select by index: " + select.getFirstSelectedOption.getText)
  driver.quit()
}
