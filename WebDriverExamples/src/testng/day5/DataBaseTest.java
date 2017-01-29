package testng.day5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DataBaseTest {

	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		//Step 1 Register driver
		Class.forName("com.mysql.jdbc.Driver");
		//Step 2 Establish connection
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root","root123");
		
		//create statemnets
		Statement st=conn.createStatement();
		
		ResultSet rs=st.executeQuery("select * from employee");
		
		ArrayList<String> list=new ArrayList<String>();
		while(rs.next()) {
			
			list.add(rs.getString(1)+" :::: "+rs.getString(2));
		}
		
	}
}
