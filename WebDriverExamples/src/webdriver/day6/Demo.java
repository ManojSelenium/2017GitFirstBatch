package webdriver.day6;

import java.util.ArrayList;
import java.util.List;

import org.testng.reporters.jq.Main;

public class Demo {

	public List findElements() {
		List l=new ArrayList();
		l.add("10");
		l.add("20");
		l.add("30");
		l.add("40");
		return l;	
	}
	public void test1() {
		
		System.out.println(findElements().get(2));
	}
	
	public static void main(String[] args) {
		
		Demo d=new Demo();
		d.test1();
	}
}
