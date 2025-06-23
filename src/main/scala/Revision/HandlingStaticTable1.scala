package Revision

import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.{By, WebElement}

object HandlingStaticTable1 extends App {
val driver = new ChromeDriver()
driver.get("https://www.w3schools.com/html/html_tables.asp")
  val table = driver.findElement(By.id("customers"))
  val rows = table.findElements(By.tagName("tr"))
  println(s"Row size ${rows.size()}" )
  for(i<-0 until rows.size()){
    val columns = rows.get(i).findElements(By.tagName("td"))
    val rowText = columns.toArray().map(_.asInstanceOf[WebElement].getText)
    println(rowText.mkString("|"))
  }

  driver.quit()
}
