package Week5Day2


import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.{By, JavascriptExecutor, WebDriver, WebElement}

object w5d2Task3 extends App {
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
  println(f"isHobby1Displayed: $isHobby1Displayed")

  val js = driver.asInstanceOf[JavascriptExecutor]
  js.executeScript("arguments[0].click();", hobby1)
//  hobby1.click()
  println("Hobby 1 is clicked")

  hobbies.forEach(hobby=>{
      if(hobby.isDisplayed) {
        println("Hobby is displayed")
        //hobby.click()}
      }else println(s"hobby not displayed")})

  //4.1 Use conditional methods to: Check if the First Name input is displayed and enabled before typing a name.
  if(firstNameInput.isDisplayed && firstNameInput.isEnabled){
    firstNameInput.sendKeys("Anna")
    println("firstname input is displayed and enabled, and first name is entered")
  }

  //4.2 Check if the Hobbies checkbox is selected; if not, select it.
  val isHhobby1Selected:Boolean = hobby1.isSelected
  println(f"Hobby1 is selected: $isHhobby1Selected" )

  //4.3 Check if the Submit button is displayed and enabled before clicking it.
  println(f"Submit button displayed: ${submitBtn.isDisplayed}")
  println(f"Submit button enabled: ${submitBtn.isEnabled}")
  val isSubmitBtnDisplayed:Boolean = hobby1.isDisplayed
  val isSubmitBtnEnabled:Boolean = hobby1.isEnabled
  println(isSubmitBtnEnabled, isSubmitBtnDisplayed)
    if(submitBtn.isDisplayed && submitBtn.isEnabled){
      js.executeScript("arguments[0].click();", submitBtn)
      submitBtn.click()
      println("Submit button is clicked")}
    else println("Submit button is not displayed or enabled")
    driver.close()
    driver.quit()
}
