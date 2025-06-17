package Week5Day4

import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.{By, JavascriptExecutor, WebElement}

object HandleJSExecutor {
  val driver = new ChromeDriver()
  driver.get("https://proleed.academy/exercises/selenium/selenium-element-id-locators-practice-form.php")

  val emailAddress: WebElement = driver.findElement(By.id("email")) //find the element by id (find through inspecting webpage
  emailAddress.sendKeys("test@gmail.com") //this is allowing us to enter an input (text) to a field (the email box in this case)
  println("Email address entered")
  val password: WebElement = driver.findElement(By.id("password"))
  password.sendKeys("TestPassword")
  println("Password entered")

  Thread.sleep(2000)

  //Not working currently - don't know enough yet. (Might need to wait.)
  val login: WebElement = driver.findElement(By.id("login")) //find submit button through id
  login.click() //click the button

  val js = driver.asInstanceOf[JavascriptExecutor]
  js.executeScript("arguments[0].scrollIntoView(view)",login)
  js.executeScript("arguments[0].click();", login)

  val header = driver.findElement(By.tagName("h2")).getText
  println("Header: " + header)
  assert(header == "Thank You!")
  println("Login successful")
  driver.quit()
}
