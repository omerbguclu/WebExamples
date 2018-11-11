package com.omerbguclu.jdbc.demo.employee;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class IncreaseSalariesForDepartment {

	public static void main(String[] args) throws SQLException {
		Connection myConnection = null;
		CallableStatement myStatement = null;
		
		String url = "jdbc:mysql://localhost:3306/demo?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false";
		String user = "demo_JDBC";
		String password = "demo_JDBC";
		try {
			// Get a connection to database
			myConnection = DriverManager.getConnection(url, user, password);
			
			String theDepartment = "Engineering";
			int theIncreaseAmount =10000;
			
			//Show salaries before
			System.out.println("Salaries Before\n");
			showSalaries(myConnection, theDepartment);
			
			//Prepare the stored procedure call
			myStatement = myConnection.prepareCall("{call increase_salaries_for_department(?,?)}");
			
			//Set the parameters
			myStatement.setString(1, theDepartment);
			myStatement.setDouble(2, theIncreaseAmount);
			
			//Call stored procedure
			System.out.println("\n\nCalling stored procedure.  increase_salaries_for_department"
								+ "('" + theDepartment +","+theIncreaseAmount+"')");
			myStatement.execute();
			System.out.println("Finished calling stored procedure");
			
			//Show salaries after
			System.out.println("Salaries After\n");
			showSalaries(myConnection, theDepartment);			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			close(myConnection,myStatement,null);
		}
	}
	private static void showSalaries(Connection myConn, String theDepartment) throws SQLException {
		PreparedStatement myStmt = null;
		ResultSet myRs = null;

		try {
			// Prepare statement
			myStmt = myConn
					.prepareStatement("select * from employees where department=?");

			myStmt.setString(1, theDepartment);
			
			// Execute SQL query
			myRs = myStmt.executeQuery();

			// Process result set
			while (myRs.next()) {
				String lastName = myRs.getString("last_name");
				String firstName = myRs.getString("first_name");
				double salary = myRs.getDouble("salary");
				String department = myRs.getString("department");
				
				System.out.printf("%s, %s, %s, %.2f\n", lastName, firstName, department, salary);
			}
		} catch (Exception exc) {
			exc.printStackTrace();
		} finally {
			close(myStmt, myRs);
		}

	}

	private static void close(Connection myConn, Statement myStmt,ResultSet myRs) throws SQLException {
		if (myRs != null) {
			myRs.close();
		}

		if (myStmt != null) {
			myStmt.close();
		}

		if (myConn != null) {
			myConn.close();
		}
	}

	private static void close(Statement myStmt, ResultSet myRs)	throws SQLException {
		close(null, myStmt, myRs);
	}

}
