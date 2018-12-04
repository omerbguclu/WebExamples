package com.omerbguclu.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.omerbguclu.aopdemo.dao.AccountDAO;

public class AfterThrowingDemoApp {

	public static void main(String[] args) {
		
		// read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		// call method to find the accounts
		List<Account> theAccounts = null;
		
		try {
			// add a boolean flag to simulate exceptions
			boolean tripWire = true;
			theAccountDAO.findAccounts(tripWire);
		} catch (Exception exc) {
			System.out.println("Found an exception: " + exc);
		}
		
		// display the accounts
		System.out.println("\n\nMain Program: AfterThrowingDemoApp\n---------------");
		
		System.out.println(theAccounts+"\n");
		
		// close the context
		context.close();		
	}
}
