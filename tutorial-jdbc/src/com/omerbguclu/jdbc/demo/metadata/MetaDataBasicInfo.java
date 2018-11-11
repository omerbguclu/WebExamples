package com.omerbguclu.jdbc.demo.metadata;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;



public class MetaDataBasicInfo {
	public static void main(String[] args) throws SQLException {
		Connection myConnection = null;
		try {
			//Get connection to database
			myConnection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/demo?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false",
					"demo_JDBC", "demo_JDBC");
			//Get metadata
			DatabaseMetaData databaseMetadata = myConnection.getMetaData();
			
			//Display info about database
			System.out.println("Product Name   -> "+databaseMetadata.getDatabaseProductName());
			System.out.println("Product Version->"+databaseMetadata.getDatabaseProductVersion()+"\n");
			
			
			//Display info about JDBC Driver
			System.out.println("JDBC Driver Name   ->"+databaseMetadata.getDriverName());
			System.out.println("JDBC Driver Version->"+databaseMetadata.getDriverVersion());
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(myConnection);
		}
	}

	private static void close(Connection myConnection) throws SQLException {
		if (myConnection != null) {
			myConnection.close();
		}
		
	}

}
