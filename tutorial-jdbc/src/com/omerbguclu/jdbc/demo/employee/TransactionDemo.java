package com.omerbguclu.jdbc.demo.employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class TransactionDemo {	
	public static void main(String[] args) throws SQLException {
		Connection myConnection = null;
		PreparedStatement myStatement1 = null;
		try {
			//Get a connection to database
			myConnection = DriverManager.getConnection(
									"jdbc:mysql://localhost:3306/demo?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false",
									"demo_JDBC", "demo_JDBC");
			
			myConnection.setAutoCommit(false);
			//Create a statement
			Statement myStatement = myConnection.createStatement();
			//Execute sql query
			System.out.println("Vanilla database.\n");
			ResultSet myResultSet4 = myStatement.executeQuery("SELECT * FROM employees");
			displayStatement(myResultSet4);
			
			
			myStatement1 = myConnection.prepareStatement("DELETE FROM employees WHERE department='HR'");
			myStatement1.executeUpdate();
			myStatement1 = myConnection.prepareStatement("UPDATE employees set salary=300 WHERE department='Engineering'");		
			myStatement1.executeUpdate();
			
			boolean ok = isItOk();
			
			if(ok) {
				myConnection.commit();
			}else {
				myConnection.rollback();
			}
			
			System.out.println("\n\nUpdated database.\n");
			myResultSet4 = myStatement.executeQuery("SELECT * FROM employees");
			displayStatement(myResultSet4);
			//Process the result set
			

		}
		catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(myConnection, myStatement1);
		}
	}
	private static void close(Connection myConn, Statement myStmt) throws SQLException {
		if (myStmt != null) {
			myStmt.close();
		}

		if (myConn != null) {
			myConn.close();
		}
	}
	
	private static void displayStatement(ResultSet myResultSet) throws SQLException {
		while(myResultSet.next()) {
			System.out.println(myResultSet.getString("id") +"- "+
					myResultSet.getString("last_name") +", "+
					myResultSet.getString("first_name") +", "+
					myResultSet.getString("email")+", "+
					myResultSet.getString("department")+", "+
					myResultSet.getString("salary"));
		}
	}
	private static boolean isItOk() {
		System.out.println("Please Enter 1 to save or Press 2 for rollback");
		Scanner reader = new Scanner(System.in);
		int isItOk = reader.nextInt();
		boolean ok =false;
		if(isItOk==1) {
			ok=true;
		}else {
			ok=false;
		}
		return ok;
	}
}
