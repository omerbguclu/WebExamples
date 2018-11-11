package com.omerbguclu.jdbc.demo.animalia;
import java.sql.*;
public class DriverAnimals {

	public static void main(String[] args) {
		try {
			//Get a connection to database
			Connection myConnection = DriverManager.getConnection(
									"jdbc:mysql://localhost:3306/kingdoms?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false",
									"demo_JDBC", "demo_JDBC");
			//Create a statement
			Statement myStatement = myConnection.createStatement();
			//Execute sql query
			ResultSet myResultSet = myStatement.executeQuery("SELECT * FROM animalia");
			//Process the result set
			while(myResultSet.next()) {
				System.out.println(myResultSet.getString("phylum") +", "+
									myResultSet.getString("class") +", "+
									myResultSet.getString("ordr") +", "+
									myResultSet.getString("family")+", "+
									myResultSet.getString("genus")+", "+
									myResultSet.getString("species"));
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
