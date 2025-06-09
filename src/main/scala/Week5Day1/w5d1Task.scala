package Week5Day1


import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.{By, WebDriver, WebElement}

object w5d1Task extends App {
 val driver:WebDriver = new ChromeDriver()
 val url:String = "https://testpages.herokuapp.com/styled/basic-html-form-test.html"
 // 1. Navigates to the above Test web URL.
 driver.get(url)
 println("1. Navigate to the test url")

 /*
 2. Enters text into:
o A username field
o A password field
o A comments/extra field
  */
 //find username by "name"
 val userName:WebElement = driver.findElement(By.name("username"))
 userName.sendKeys("test1@gmail.com")
 println("2.1: user name is entered")

 //find password input with cssSelector
 val password:WebElement = driver.findElement(By.cssSelector("input[name='password']"))
 password.sendKeys("password123")
 println("2.2 : password is entered")

 // find textarea by tagName
 val comment:WebElement = driver.findElement(By.tagName("textarea"))
 comment.clear()
 comment.sendKeys("add comment in textarea")
 println("2.3 : comment is added")

 /*
 3. Clicks on:
o A checkbox
o A submit button
o A link on the page
  */
 //find checkboxes with tag & attribute
 val checkBox1:WebElement = driver.findElement(By.cssSelector("input[value='cb1']"))
 val checkBox3 :WebElement = driver.findElement(By.cssSelector("input[checked='checked']"))
 checkBox3.click()
 checkBox1.click()
 println("3.1 check box 1 is clicked")

 //xpath
 val radio1:WebElement = driver.findElement(By.xpath ("//td/input[@value='rd1']"))
 radio1.click()
 //look at drop down menu how to select

 // find submit button with css class & value attribute
 val submitBtn:WebElement = driver.findElement(By.cssSelector(".styled-click-button[value='submit']"))
 submitBtn.click()
 println("3.2 submit button is clicked")

 val evilTesterLink :WebElement = driver.findElement(By.linkText("EvilTester.com"))
 evilTesterLink.click()
 println("3.3 Evil Tester clicked")

 val compendiumDevelopments:WebElement = driver.findElement(By.partialLinkText("Compendium Developments"))
 compendiumDevelopments.click()
 println("Compendium development clicked")
 driver.quit()
}
