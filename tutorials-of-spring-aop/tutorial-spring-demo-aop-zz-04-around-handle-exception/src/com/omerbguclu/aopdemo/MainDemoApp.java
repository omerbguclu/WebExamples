package com.omerbguclu.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.omerbguclu.aopdemo.dao.AccountDAO;
import com.omerbguclu.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		
		// read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		MembershipDAO theMembershipDAO = context.getBean("membershipDAO", MembershipDAO.class);
		
		// call the business method
		theAccountDAO.addAccount();

		// call the business method
		Account account = new Account("Madhu","Platinum");
		theAccountDAO.addAccount(account);
		
		// call the business method
		theAccountDAO.addAccount(account,true);
		
		// call the business method
		theAccountDAO.updateAccount();
		
		// call the business method
		theMembershipDAO.addAccount();
		
		// call the accountDAO getter/setter methods
		theAccountDAO.setName("Project-1");
		theAccountDAO.setServiceCode("012");
		theAccountDAO.getName();
		theAccountDAO.getServiceCode();
		
		// close the context
		context.close();		
	}
}
