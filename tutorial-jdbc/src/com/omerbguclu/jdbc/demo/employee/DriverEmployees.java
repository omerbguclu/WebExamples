package com.omerbguclu.jdbc.demo.employee;
import java.sql.*;
public class DriverEmployees {

	public static void main(String[] args) {
		try {
			//Get a connection to database
			Connection myConnection = DriverManager.getConnection(
									"jdbc:mysql://localhost:3306/demo?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false",
									"demo_JDBC", "demo_JDBC");
			//Create a statement
			Statement myStatement = myConnection.createStatement();
			//Execute sql query
			ResultSet myResultSet = myStatement.executeQuery("SELECT * FROM employees");
			//Process the result set
			while(myResultSet.next()) {
				System.out.println(myResultSet.getString("id") +"- "+
									myResultSet.getString("last_name") +", "+
									myResultSet.getString("first_name") +", "+
									myResultSet.getString("email")+", "+
									myResultSet.getString("department")+", "+
									myResultSet.getString("salary"));
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
