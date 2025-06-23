package Week5Day2

import org.openqa.selenium.By
import org.openqa.selenium.chrome.ChromeDriver

import scala.jdk.CollectionConverters.CollectionHasAsScala


object Extention extends App {
  /*
  1. What is the difference between .close() and .quit() in different scenarios?
 o Try closing one tab vs closing the entire session.
 o Research how they behave when multiple windows/tabs are open.
 */

  //.close closes the current focused window, while.quite closes all windows

  /*
  2. How does Selenium handle multiple browser windows?
  o Investigate getWindowHandles() and how to switch between windows.
  */

  val driver = new ChromeDriver()
  driver.get("https://the-internet.herokuapp.com/windows")
  try {
    val currentHandle = driver.getWindowHandle
  driver.findElement(By.linkText("Click Here")).click()
    println("Current window title: " +driver.getTitle, "_Handle: " + currentHandle)
    val windowHandles = driver.getWindowHandles.asScala.toList
    println("windowHandles tail: ", windowHandles.tail)
    println("windowHandles head: ", windowHandles.head)
    driver.switchTo().window(windowHandles(1))

    driver.switchTo().window(windowHandles.head)

  } catch {
    //to catch error if driver.findElement find nothing then returns a NoSuchElementException
    case e: NoSuchElementException => throw new AssertionError("Element not found")
  } finally {
driver.quit()
  }


  /*
  3. What are the alternatives to .navigate().to()?
  o Is it functionally the same as driver.get()? Are there performance
  differences?
  */

  // they perform almost the same function. The .get waits for the webpackage to be loaded properly, does not support navigation history/refresh/forward feature
  //.navigate().to() does not wait for webpackag, is a function of navigation interface. .navigate().refresh(), .navigate().forward(), .navigate().back()

  /*
4. What is the difference between findElement() and findElements()?
o What happens if the locator doesn't match anything?
o How does the return type differ?
*/
// findElement() returns the first matching element, throws NoSuchElementException when element not found
  // findElements() return a list of matching elements, return empty list when no element is found

  /*
5. Selenium Manager (Selenium 4.6+)
o What does it do and how does it simplify browser driver management?
  */
//Selenium Manager automatically detects the browser version and downloads the appropriate driver, removing the need for manual driver downloads and configuration.

}
