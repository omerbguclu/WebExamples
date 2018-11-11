package com.omerbguclu.jdbc.demo.animalia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PreparingStatements {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/kingdoms?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false";
		String user = "demo_JDBC";
		String password = "demo_JDBC";
		
		try {
			// Get a connection to database
			Connection myConnection4 = DriverManager.getConnection(url, user, password);			
			// Create a statement
			Statement myStatement1 = myConnection4.createStatement();			
			// Execute SQL query
			String sql ="insert into animalia" +
						" (phylum, class, ordr, family, genus, species)"+
						" values ('Chordata','Mammalia','Carnivora','Felidae','Panthera','Tiger(Panthera Tigris)')";
			myStatement1.executeUpdate(sql);
			ResultSet myResultSet4 = myStatement1.executeQuery("SELECT * FROM animalia");
			displayStatement(myResultSet4);			
			System.out.println("Insert Completed."+"\n\n");
			
			
			
			// Search for update
			PreparedStatement myStatement4 = myConnection4.prepareStatement("update animalia set species=? where id>=?");
			myStatement4.setString(1, "Panthera tigris (Tiger)");
			myStatement4.setInt(2, 0);
			// Execute SQL query
			int rowsAffected = myStatement4.executeUpdate();
			System.out.println("Rows Affected: " + rowsAffected);
			System.out.println("Update complete.");
			myResultSet4 = myStatement4.executeQuery("SELECT * FROM animalia");
			displayStatement(myResultSet4);			
			System.out.println("Search Completed."+"\n\n");
			
			
			
			// Create a statement
			myStatement4 = myConnection4.prepareStatement("select * from animalia where species=? and id>=?");			
			// Set the parameters
			myStatement4.setString(1,"Panthera tigris (Tiger)");
			myStatement4.setInt(2, 0);
			// Execute SQL query
			myResultSet4= myStatement4.executeQuery();			
			displayStatement(myResultSet4);
			System.out.println("Search Completed."+"\n\n");
			
			
			
			//Search again			
			myStatement4.setString(1,"Panthera tigris (Tiger)");
			myStatement4.setInt(2, 0);
			// Execute SQL query
			myResultSet4= myStatement4.executeQuery();
			displayStatement(myResultSet4);
			System.out.println("Search Completed."+"\n\n");
			
			
			
			// Search for delete
			myStatement4 = myConnection4.prepareStatement("delete from animalia where species=? and id>=?");
			myStatement4.setString(1, "Panthera tigris (Tiger)");
			myStatement4.setInt(2, 0);
			// Execute SQL query
			rowsAffected = myStatement4.executeUpdate();
			System.out.println("Rows Affected: " + rowsAffected);
			System.out.println("Delete complete. ");
			

			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void displayStatement(ResultSet myResultSet4) throws SQLException {
		while(myResultSet4.next()) {
			System.out.println( myResultSet4.getInt("id")+","+
								myResultSet4.getString("phylum") +", "+
								myResultSet4.getString("class") +", "+
								myResultSet4.getString("ordr") +", "+
								myResultSet4.getString("family")+", "+
								myResultSet4.getString("genus")+", "+
								myResultSet4.getString("species"));
		}
	}

}
