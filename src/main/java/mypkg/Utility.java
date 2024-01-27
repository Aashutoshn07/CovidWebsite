package mypkg;

import java.sql.Connection;
import java.sql.DriverManager;

public class Utility {
	
	private static Connection con;
	
	public static Connection connect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/coviddata","root","Ashu@40201");			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return con;
	} 
}
