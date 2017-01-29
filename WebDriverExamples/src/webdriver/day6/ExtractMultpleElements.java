package webdriver.day6;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ExtractMultpleElements {

	
	public static void main(String[] args) {
		
		WebDriver driver=new FirefoxDriver();
		
		driver.get("https://www.google.com/advanced_search");
		
//		WebElement text=driver.findElement(By.name("as_q"));
//		System.out.println(text);
//		text.sendKeys("selenium");
		String[] testData=new String[7];
		testData[0]="first name";
		testData[1]="last name";
		testData[2]="middle name";
		testData[3]="email name";
		testData[4]="class name";
		testData[5]="phone  name";
		testData[6]="test";
		
		List<WebElement> textBoxes=driver.findElements(By.xpath("//input[@type='text']"));
		
		for(int i=0;i<textBoxes.size();i++) {
			textBoxes.get(i).sendKeys(testData[i]);
		}
		
		
		
		
		
	}
}
