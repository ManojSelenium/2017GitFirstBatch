package webdriver.day4;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class AlertDemo {

	public static void main(String[] args) {
		
		WebDriver driver=new FirefoxDriver();
		
		driver.get("http://kesinenitravels.com/CheckFareDetails.aspx");
		
		//Click on Search Button
		driver.findElement(By.id("ctl00_cpEndUserMain_ibtnSearch")).click();
		
		//handel Alert
		Alert alert=driver.switchTo().alert();
		
		System.out.println(alert.getText());
		
		if(alert.getText().equals("Select Source")) {
			alert.accept();
		}
		//Select Source
		new Select(driver.findElement(By.id("ctl00_cpEndUserMain_ddlSource"))).selectByVisibleText("HYDERABAD");
		
		
		
	}
	
	
}
