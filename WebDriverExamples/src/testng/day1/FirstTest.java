package testng.day1;

import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstTest {

	
	@Test
	public void tc_1() {
		System.out.println("First Test Case");
		Assert.assertEquals("test", "test123");
	}
	
	@Test
	public void tc_2() {
		System.out.println("Second Test Case");
	}
	
	@Test
	public void tc_3() {
		System.out.println("Third Test Case");
	}
}
