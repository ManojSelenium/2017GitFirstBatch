package webdriver.day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ConfirmationMessage {

	
	public static void main(String[] args) {
		
		
		WebDriver driver=new FirefoxDriver();
		
		driver.get("http://softwaretesting-guru.blogspot.in/p/blog-page.html");
		
		
		driver.findElement(By.xpath("//input[@value='Display a confirm box']")).click();
		
		driver.switchTo().alert().accept();
	}
}
