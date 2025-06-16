package Week5Day4
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.{By, WebElement}

object HandleStaticTable extends App
{
  val driver = new ChromeDriver()
  //    Navigate to a web page containing a static HTML table
  driver.get("https://www.w3schools.com/html/html_tables.asp")
  val rows: java.util.List[WebElement] = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr[position() > 1]"))
  for (i <- 0 to rows.size() ){
    val cols = rows.get(i).findElements(By.tagName("td"))
    val rowText = cols.toArray.map(_.asInstanceOf[org.openqa.selenium.WebElement].getText).mkString("|")
    println(s"Row ${i + 1}: $rowText")
  }


}
