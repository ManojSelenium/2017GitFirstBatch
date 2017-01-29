package webdriver.day8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ESPNWebTable {

	
	public static void main(String[] args) throws InterruptedException {
		
	System.setProperty("webdriver.chrome.driver", "D:\\JARS\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
	
		driver.get("http://www.espncricinfo.com/ci/engine/match/1074963.html");
		
		driver.findElement(By.id("st_1")).click();
		
		Thread.sleep(5000);
		//*[@id='full-scorecard']/div[2]/div/table[1]/tbody/tr[2]/td[2]
		
		//*[@id='full-scorecard']/div[2]/div/table[1]/tbody/tr[4]/td[2]
		
		String xpath_Start="//*[@id='full-scorecard']/div[2]/div/table[1]/tbody/tr[";
		String xpath_End="]/td[2]";
		
		int i=2;
		for(i=2;i<=16;i=i+2) {
			String batsMen=driver.findElement(By.xpath(xpath_Start+i+xpath_End)).getText();
			System.out.println(batsMen);
		}
	}
}
