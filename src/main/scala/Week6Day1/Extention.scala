package Week6Day1

import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.support.ui.{ExpectedConditions, WebDriverWait}
import org.openqa.selenium.{By, JavascriptExecutor, WebDriver, WebElement}

import java.time.Duration
object Extention extends App {

  /*
 Write a Scala program that clicks a column header to trigger sorting, then verifies that the rows on
the page are in the correct order (ascending and descending).
URL: https://the-internet.herokuapp.com/tables
The page contains two sortable HTML tables (#table1, #table2).
Clicking any column header cycles unsorted → ascending → descending.
1. Navigate to the URL and locate Table 1.
2. Trigger sorting.
3. Capture the column values after each click.
4.
   */
  val driver: WebDriver = new ChromeDriver()
  driver.get("https://the-internet.herokuapp.com/tables")
  val table1:WebElement = driver.findElement(By.id("table1"))
  val table1Headers = table1.findElements(By.className("header"))
  println(table1Headers.get(1).getText)


// explicit wait
  val lastNameHeader:WebElement = table1Headers.get(0)
  val explicitWait = new WebDriverWait(driver,Duration.ofSeconds(3))
  explicitWait.until(ExpectedConditions.visibilityOf(lastNameHeader))
  lastNameHeader.click()
  val lastNameClass: String = lastNameHeader.getAttribute("class")
//  lastNameClass.tail

  val addedClass = lastNameClass.slice(7, lastNameClass.length)
  if(lastNameClass.contains("headerSortDown") || lastNameClass.contains("headerSortUp")){
    println("sorted")
//  makeScreenshot(addedClass)
  }

  val js = driver.asInstanceOf[JavascriptExecutor]

//  driver.quit()
}
