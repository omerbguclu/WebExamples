package com.omerbguclu.hibernate.demo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJDBC {
	public static void main(String[] args) {
		String jdbcUrl = "jdbc:mysql://localhost:3306/hb_student_tracker?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false";
		String user = "hbstudent";
		String pass = "hbstudent";
		
//		TimeUtil.class.getResourceAsStream(TIME_ZONE_MAPPINGS_RESOURCE);
		
		try {
			System.out.println("Connection to database: " + jdbcUrl);
			Connection myconn = DriverManager.getConnection(jdbcUrl, user, pass);
			System.out.println("Connection Succesful!!");
			
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}

}
