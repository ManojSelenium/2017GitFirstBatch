package webdriver.day5;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CopyandPasteDemo {

	public static void main(String[] args) {


		WebDriver driver = new FirefoxDriver();

		driver.get("https://www.google.com/advanced_search");

		driver.findElement(By.id("_dKg")).sendKeys("selenium");
		
		driver.findElement(By.id("_dKg")).sendKeys(Keys.CONTROL+"a");
		
		driver.findElement(By.id("_dKg")).sendKeys(Keys.CONTROL+"c");
		
		
		
		driver.findElement(By.id("_aKg")).sendKeys(Keys.CONTROL+"v");
		driver.findElement(By.id("_aKg")).sendKeys(Keys.CONTROL+"v");
		driver.findElement(By.id("_aKg")).sendKeys(Keys.CONTROL+"v");
		
	}
}
