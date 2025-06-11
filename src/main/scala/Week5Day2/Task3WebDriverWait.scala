package Week5Day2

import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.support.ui.{ExpectedConditions, WebDriverWait}
import org.openqa.selenium.{By, WebDriver, WebElement}

import java.time.Duration

object Task3WebDriverWait extends App {
  //Task 3:
  val url:String = "https://demoqa.com/automation-practice-form"
  //  1. Launch the browser using WebDriver.
  val driver:WebDriver = new ChromeDriver()

  //2. Navigate to the test URL.
  driver.navigate().to(url)
  driver.manage().window().maximize()

 //3.1 Locate First Name input
  val firstNameInput:WebElement = driver.findElement(By.id("firstName"))
  println("First name located")

  //3.2 Locate Submit button
  val submitBtn: WebElement = driver.findElement(By.cssSelector("button[id='submit']"))
  println("Submit button located")

  //3.3 Locate Hobbies checkbox
  val hobbies: java.util.List[WebElement] = driver.findElements(By.cssSelector("input[type='checkbox']"))
  val hobby1:WebElement = driver.findElement(By.id("hobbies-checkbox-1"))
  val isHobby1Displayed = hobby1.isDisplayed
  println(f"Is hobby1 displayed before wait: $isHobby1Displayed")
  val webDriverWait  = new WebDriverWait(driver, Duration.ofSeconds(5))
  webDriverWait.until(ExpectedConditions.elementToBeClickable(hobby1))
  val isHobby1DispalyedAfterWait = hobby1.isDisplayed
  println(f"Is hobby1 displayed before wait: $isHobby1DispalyedAfterWait")
  hobby1.click()
  println("Hobby 1 clicked")


  //4.1 Use conditional methods to: Check if the First Name input is displayed and enabled before typing a name.
  if(firstNameInput.isDisplayed && firstNameInput.isEnabled){
    firstNameInput.sendKeys("Anna")
  }
  println("Enter first name when it is displayed and enabled")
  //4.2 Check if the Hobbies checkbox is selected; if not, select it.

  //4.3 Check if the Submit button is displayed and enabled before clicking it.
//  if(submitBtn.isDisplayed && submitBtn.isEnabled){submitBtn.click()}
//  println("Submit button is clicked")
//  driver.close()
//  driver.quit()
}
