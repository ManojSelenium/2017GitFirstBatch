package webdriver.day9;

public class EnchancedForLoop {

	
	public static void main(String[] args) {
		
		String a[]=new String[3];
		
		a[0]="selenium1";
		a[1]="selenium2";
		a[2]="selenium3";
		/*
		for(int i=0;i<a.length;i++) {
			System.out.println(a[i]);
		}*/
		
		for(String temp : a) {
			System.out.println(temp);
		}
	}
}
