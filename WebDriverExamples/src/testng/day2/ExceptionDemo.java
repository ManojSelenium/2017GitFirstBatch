package testng.day2;

public class ExceptionDemo {


	public static void main(String[] args) {
		try{
			String a[]=new String[3];

			a[0]="10";
			a[1]="20";
			a[2]="30";
			a[3]="40";

			for(int i=0;i<a.length;i++) {
				System.out.println(a[i]);
			}
		}catch (Exception e) {
			System.out.println("Your array size is full Increase the size");
		}
	}
}
