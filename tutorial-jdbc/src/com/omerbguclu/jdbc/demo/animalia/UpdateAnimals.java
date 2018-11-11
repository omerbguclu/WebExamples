package com.omerbguclu.jdbc.demo.animalia;
import java.sql.*;
public class UpdateAnimals {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/kingdoms?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false";
		String user = "demo_JDBC";
		String password = "demo_JDBC";
		
		try {
			// Get a connection to database	
			Connection myConnection2 = DriverManager.getConnection(url, user, password);
			
			// Create a statement
			Statement myStatement2 = myConnection2.createStatement();
			
			// Execute SQL query
			String sql ="update animalia "+
						"set species='Panthera tigris (Tiger)' "+
						"where id=2";
			myStatement2.executeUpdate(sql);
			System.out.println("Update complete.");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
