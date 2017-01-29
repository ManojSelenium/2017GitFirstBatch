package testng.day4;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DependsOnTest {

	
	@Test
	public void createUserTest() {
	System.out.println("First Test Case");
	Assert.assertEquals("test","test");
	}
	

	@Test(dependsOnMethods="createUserTest")
	public void editUserTest() {
	System.out.println("Second Test Case");	
	}
	

	@Test(dependsOnMethods="createUserTest")
	public void deleteUserTest() {
	System.out.println("Third Test Case");	
	}
	
}
