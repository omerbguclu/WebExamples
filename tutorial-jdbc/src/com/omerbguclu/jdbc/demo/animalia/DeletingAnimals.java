package com.omerbguclu.jdbc.demo.animalia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DeletingAnimals {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/kingdoms?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false";
		String user = "demo_JDBC";
		String password = "demo_JDBC";
		
		try {
			// Get a connection to database
			Connection myConnection3 = DriverManager.getConnection(url, user, password);
			
			// Create a statement
			Statement myStatement3 = myConnection3.createStatement();
			
			// Execute SQL query
			String sql = "delete from animalia where id=1";
			//String sql = "delete from animalia where species='Panthera tigris (Tiger)'";
			//String sql = "delete from animalia where ordr='Carnivora'";
			int rowsAffected = myStatement3.executeUpdate(sql);
			
			System.out.println("Rows affacted: "+rowsAffected);
			System.out.println("Delete complete.");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
