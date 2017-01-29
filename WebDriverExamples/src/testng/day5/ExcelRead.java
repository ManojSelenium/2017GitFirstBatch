package testng.day5;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ExcelRead {

	WebDriver driver;
	public void testCase() throws IOException, InterruptedException {
		System.setProperty("webdriver.chrome.driver","D:\\JARS\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		//driver=new FirefoxDriver(); 
		driver.get("https://www.rightstart.com/customer/account/login");

		ArrayList<String> usernamelist=readDataFromExcel(0);
		ArrayList<String> passwordlist=readDataFromExcel(1);
		for(int i=0;i<usernamelist.size();i++ ) {
		driver.findElement(By.id("email")).sendKeys(usernamelist.get(i));
		driver.findElement(By.id("pass")).sendKeys(passwordlist.get(i));
		driver.findElement(By.id("send2")).click();
		//Thread.sleep(8000);
		driver.findElement(By.xpath("//*[contains(text(),'Sign Out')]")).click();
		Thread.sleep(8000);
		driver.findElement(By.xpath("//*[contains(text(),'Sign In')]")).click();
		Thread.sleep(6000);
		
		}
	}

	public ArrayList<String> readDataFromExcel(int colno) throws IOException {

		FileInputStream fis=new FileInputStream(new File("C:\\Users\\DELL\\Desktop\\testdata.xls"));

		HSSFWorkbook wb=new HSSFWorkbook(fis);
		HSSFSheet s=wb.getSheetAt(2);
		Iterator<Row> rowIt=s.iterator();
		ArrayList<String> excelData=new ArrayList<String>();
		rowIt.next();
		while(rowIt.hasNext()) {
			excelData.add(rowIt.next().getCell(colno).getStringCellValue());
		}

		return excelData;

	}
	
	public static void main(String[] args) throws IOException, InterruptedException {
		ExcelRead read=new ExcelRead();
		read.testCase();
	}
}

