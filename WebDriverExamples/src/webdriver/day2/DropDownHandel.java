package webdriver.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownHandel {

	
	public static void main(String[] args) {
		
		WebDriver driver=new FirefoxDriver();
		
		driver.get("http://softwaretesting-guru.blogspot.in/p/blog-page.html");
		
		WebElement textBox=driver.findElement(By.name("Name"));
		
		textBox.sendKeys("selenium");
		
		new Select(driver.findElement(By.name("countries"))).selectByVisibleText("Argentina");;
		
	}
	
}
