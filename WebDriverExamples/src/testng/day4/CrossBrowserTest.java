package testng.day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import webdriver.day7.GenerateData;

public class CrossBrowserTest implements SetUp{
	
	WebDriver driver;
	//Locators
	Reporter report=new Reporter();
	By guestCheckoutLocator=By.xpath("//*[contains(@title,'Guest Checkout')]");
	By firstNameLocator=By.id("firstname");
	By lastNameLocator=By.id("lastname");
	By emailAddressNameLocator=By.id("email_address");
	By hearAboutDropdownLocator=By.id("hear_about_us");
	By passwordLocator=By.id("password");
	By confirmPasswordLocator=By.id("confirmation");
	By createAccountButtonLocator=By.xpath("//*[contains(@class,'button btn_shipping')]");
	By scuessMsgLocator=By.xpath("//*[contains(text(),'Thank you for registering with Right Start.')]");
	By editButtonLocator=By.xpath("(//*[contains(text(),'Edit')])[1]");
	By editFirstNameLcoator=By.id("firstname");
	By editLastNameLocator=By.id("lastname");
	By editPageSaveButton=By.xpath("//*[contains(@title,'Save')]");
	By editAccountMsg=By.xpath("//*[contains(text(),'The account information has been saved.')]");
	
	//This will execute before test case
	@Parameters("sBrowser")
	@BeforeMethod
	public void setUp(@Optional(SBROWSER)String sBrowser) {
		
		if(sBrowser.equalsIgnoreCase("chrome")) {
		System.setProperty("webdriver.chrome.driver","D:\\JARS\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		}else if(sBrowser.equalsIgnoreCase("firefox")) {
		driver=new FirefoxDriver();
		}
		//report.log("Browser Launched");
		enterURL(autoationURl);
		//report.log("URL Entered and the URL is ::: "+autoationURl);
	}
	//First Test Case
	@Test
	public void AT_Verify_createAccountTest() {
		
		click(guestCheckoutLocator);
		
		reporter("Clicked Guest Checkout");
		enterText(firstNameLocator, GenerateData.generateRandomString());
		reporter("First name entred");
		enterText(lastNameLocator, GenerateData.generateRandomString());
		reporter("Last name entered");
		enterText(emailAddressNameLocator, GenerateData.generateRandomString()+"@mailinator.com");
		reporter("Email Address enetred");
		selectValue(hearAboutDropdownLocator, "Email");
		//report.log("Selected Value From Dropdown");
		String sPassword="Password@123";
		enterText(passwordLocator, sPassword);
		//report.log("Password Entred and the password is "+sPassword);
		enterText(confirmPasswordLocator, sPassword);
		//report.log("Confrim Password Entred and the password is "+sPassword);
		click(createAccountButtonLocator);
		//report.log("Continue Button Clicked");
		String actualData=getText(scuessMsgLocator);
		System.out.println("Actual Data :::: "+actualData);
		String expectedData="Thank you for registering with Right Start.";
		
		Assert.assertEquals(actualData, expectedData);
		/*if(expectedData.equalsIgnoreCase(actualData) ) {
			System.out.println("Test Case pass");
		}else {
			System.out.println("Test Case Fail");
		}*/
	}
	
	int i=0;
	
	public int getI() {
		i++;
		return i;
	}

	public void setI(int i) {
		this.i = i;
		
	}

	public void resetI() {
		this.i=0;
	}
	
	//Second Test Case
	@Test
	public void AT_Verify_UpdateAccountTest() {
		
		click(guestCheckoutLocator);
		reporter("Clicked Guest Checkout");
		enterText(firstNameLocator, GenerateData.generateRandomString());
		reporter("First Name Entered");
		enterText(lastNameLocator, GenerateData.generateRandomString());
		reporter("last name entered");
		enterText(emailAddressNameLocator, GenerateData.generateRandomString()+"@mailinator.com");
		reporter("Email address entered");
		selectValue(hearAboutDropdownLocator, "Email");
		String sPassword="Password@123";
		enterText(passwordLocator, sPassword);
		enterText(confirmPasswordLocator, sPassword);
		click(createAccountButtonLocator);
		click(editButtonLocator);
		clearTextBox(editFirstNameLcoator);
		enterText(editFirstNameLcoator, GenerateData.generateRandomString());
		clearTextBox(editLastNameLocator);
		enterText(editLastNameLocator, GenerateData.generateRandomString());
		click(editPageSaveButton);
		
		String expectedData="The account information has been saved.";
		String actlaData=getText(editAccountMsg);
		System.out.println("Actla Data For Edit Account test case ::"+actlaData);
		Assert.assertEquals(actlaData, expectedData);
		/*if(expectedData.equalsIgnoreCase(actlaData)) {
			System.out.println("Account name Updated Test case Pass :::");
		}else {
			System.out.println("Test Case Fail");
		}*/
	}
	
	public void reporter(String logMsg) {
		report.log("Step "+getI()+" "+logMsg);
	}
	
	//This will execute after test case
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
		resetI();
	}
	
	public void enterURL(String sURL) {
		
		driver.get(sURL);
	}
	
	public void pause(int millis) {
		
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void click(By prop) {
		pause(2000);
		driver.findElement(prop).click();
	}
	
	public void enterText(By prop,String testData) {
		
		driver.findElement(prop).sendKeys(testData);
	}
	public void selectValue(By prop,String optionValue) {
		new Select(driver.findElement(prop)).selectByVisibleText(optionValue);
	}
	
	public String getText(By prop) {
		pause(4000);
		return driver.findElement(prop).getText();
	}

	public void clearTextBox(By prop) {
		pause(3000);
		driver.findElement(prop).clear();
	}
}
