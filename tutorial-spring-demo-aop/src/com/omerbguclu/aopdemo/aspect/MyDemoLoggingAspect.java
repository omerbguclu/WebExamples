package com.omerbguclu.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	
	// this is where we add all of our related advices for logging
	
	// let's start with an @Before advice
	
	//All add*(wildcard) method sub of "com.omerbguclu.aopdemo" 
	@Before("execution(public void add*())")
	public void beforeAddWildcardAdvice() {
		System.out.println("1-------> Executing @Before advice on add*()");
	}
	
	//All addAccount method sub of "com.omerbguclu.aopdemo"
	@Before("execution(public void addAccount())")
	public void beforeAddAllAccountAdvice() {
		System.out.println("2-------> Executing @Before advice on addAccount()");
	}
	
	//Only addAccount method for "com.omerbguclu.aopdemo.dao.AccountDAO.addAccount())"
	@Before("execution(public void com.omerbguclu.aopdemo.dao.AccountDAO.addAccount())")
	public void beforeAddAccountAdvice() {
		System.out.println("3-------> Executing @Before advice on com.omerbguclu.aopdemo.dao.AccountDAO.addAccount()");
	}
	
	//All updateAccount sub of "com.omerbguclu.aopdemo"
	@Before("execution(public void updateAccount())")
	public void beforeUpdateAccountAdvice() {
		System.out.println("4-------> Executing @Before advice on updateAccount()");
	}
	
	//All add*(wildcard) method and specified parameter sub of "com.omerbguclu.aopdemo"  
	@Before("execution(public void add*(com.omerbguclu.aopdemo.Account))")
	public void beforeAddParameterAdvice() {
		System.out.println("5-------> Executing @Before advice on add(with specific parameter)");
	}
	
	//All add*(wildcard) method and with zero or more parameter sub of "com.omerbguclu.aopdemo"  
	@Before("execution(public void add*(..))")
	public void beforeAddZeroOrMoreParameterAdvice() {
		System.out.println("6-------> Executing @Before advice on add(with zero or more parameter)");
	}
	
	//All add*(wildcard) method and with parameter*(wildcard) sub of "com.omerbguclu.aopdemo"  
	@Before("execution(public void add*(*))")
	public void beforeAddWildcardParameterAdvice() {
		System.out.println("7-------> Executing @Before advice on add(parameter*(wildcard))");
	}
	
	//Only addAccount method, any*(wildcard) return type with zero or more parameter sub "com.omerbguclu.aopdemo.dao.*.*(..))"
	@Before("execution(* com.omerbguclu.aopdemo.dao.*.*(..))")
	public void beforeAddWildcardAndZeroOrMoreParameterAdvice() {
		System.out.println("8-------> Executing @Before advice on com.omerbguclu.aopdemo.dao.*.*(..)");
	}
}