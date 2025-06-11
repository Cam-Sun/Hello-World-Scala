package Week5Day3

import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.support.ui.Select
import org.openqa.selenium.{By, WebDriver, WebElement}

object MVP  extends App {
  val driver:WebDriver = new ChromeDriver()
  val url:String = "https://testpages.herokuapp.com/styled/index.html"
  //1 Navigate to the site. Once here, maximise the page.
  driver.navigate().to(url)
  driver.manage().window().maximize()

  //2. Handle Text Boxes.
  // Go to the "HTML Form Example" page
  val htmlFormExampleLink: WebElement = driver.findElement(By.linkText("HTML Form Example"))
  htmlFormExampleLink.click()
  println("On HTML Form Example Page")
  //// Fill in the username and password fields.
 val userNameInput: WebElement = driver.findElement(By.name("username"))
  userNameInput.sendKeys("tester1@test.com")
  println("Username is entered")
  val passwordInput: WebElement = driver.findElement(By.name("password"))
  passwordInput.sendKeys("tester12345!")
  println("Password entered")

  //3. Handle Checkbox:
  //• Locate a checkbox.
  //• Select the checkbox located if not already selected.
  val checkBox1:WebElement = driver.findElement(By.cssSelector("input[value='cb1']"))
  if(!checkBox1.isSelected)checkBox1.click()
  val cb3:WebElement= driver.findElement(By.xpath("//input[@value='cb3']"))
  cb3.click()
  println("Checkbox1 selected & checkbox 3 unslected")

  //4. Handle Radio Buttons:
  //• Select a radio option.
  val radioBtn:WebElement = driver.findElement(By.cssSelector("input[value='rd1']"))
  radioBtn.click()
  println("Radio button 1 clicked")

  //5. Handle Dropdown/Select:
  //• Choose an option from the dropdown.
  val multiSelect = new Select(driver.findElement(By.name("multipleselect[]")))
  multiSelect .selectByIndex(1)
  println("Drop down item selected")

  //6. Handle Buttons:
  //• Click the "Submit" button.
  val submitBtn: WebElement = driver.findElement(By.cssSelector("input[value='submit']"))
  println(submitBtn.getAttribute("value"))
//  val js = driver.asInstanceOf[JavascriptExecutor]
//  js.executeScript("arguments[0].click();",submitBtn)
  println("Submit button displayed: " + submitBtn.isDisplayed)
  println("Submit button enabled: " + submitBtn.isEnabled)
  println("Button text: " + submitBtn.getAttribute("value"))
  submitBtn.click()

//7. Handle Links:
  //• Click a link to return to the homepage.
 val backToForm:WebElement = driver.findElement(By.id("back_to_form"))
  backToForm.click()


  driver.quit()
}
