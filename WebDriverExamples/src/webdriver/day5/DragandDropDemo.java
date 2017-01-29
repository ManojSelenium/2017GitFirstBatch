package webdriver.day5;

import java.awt.event.ActionEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class DragandDropDemo {

	
	public static void main(String[] args) throws InterruptedException {
		
		
		WebDriver driver=new FirefoxDriver();
		
		
		driver.get("http://www.hdfcbank.com");
		
		Thread.sleep(5000);
		/*Actions builder=new Actions(driver);
		
		WebElement source=driver.findElement(By.xpath("//*[contains(text(),'all these words')]"));;
		WebElement destination =driver.findElement(By.id("_dKg"));
		
		builder.dragAndDrop(source, destination).build().perform();*/
		
		
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.ENTER);
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.ESCAPE);
	}
}
