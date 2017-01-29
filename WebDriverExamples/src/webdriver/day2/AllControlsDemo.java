package webdriver.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AllControlsDemo {

	
	public static void main(String[] args) throws InterruptedException {
		
		//Launch the browser
		WebDriver driver=new FirefoxDriver();
		
		//Enter URL
		driver.get("http://softwaretesting-guru.blogspot.in/p/main-page.html");
		
		//click on Selenium Practice page link
		driver.findElement(By.linkText("Selenium Practice page")).click();
		Thread.sleep(6000);
		
		//Handel textBox
		driver.findElement(By.name("Name")).sendKeys("selenium");
		
		//Handel CheckBox
		driver.findElement(By.name("subscribe")).click();
		
		//Handel text area
		driver.findElement(By.name("comments")).sendKeys("Hi Team how are you doing");

		//Handel Radio Button
		driver.findElement(By.xpath("//input[@type='radio' and @value='bad']")).click();
	}
	
}
