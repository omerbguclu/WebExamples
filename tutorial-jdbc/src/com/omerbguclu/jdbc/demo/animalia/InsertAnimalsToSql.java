package com.omerbguclu.jdbc.demo.animalia;
import java.sql.*;
public class InsertAnimalsToSql {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/kingdoms?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false";
		String user = "demo_JDBC";
		String password = "demo_JDBC";
		
		try {
			// Get a connection to database
			Connection myConnection1 = DriverManager.getConnection(url, user, password);
			
			// Create a statement
			Statement myStatement1 = myConnection1.createStatement();
			
			// Execute SQL query
			String sql ="insert into animalia" +
						" (phylum, class, ordr, family, genus, species)"+
						" values ('Chordata','Mammalia','Carnivora','Felidae','Panthera','Tiger(Panthera Tigris)')";
			
			myStatement1.executeUpdate(sql);
			
			System.out.println("Insert Completed.");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
