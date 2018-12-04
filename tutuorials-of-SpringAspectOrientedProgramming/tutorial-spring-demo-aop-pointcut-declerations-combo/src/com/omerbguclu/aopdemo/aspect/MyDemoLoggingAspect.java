package com.omerbguclu.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	
	// this is where we add all of our related advices for logging
	
	// let's start with an @Before advice
	
	@Pointcut("execution(* com.omerbguclu.aopdemo.dao.*.*(..))")
	private void forDaoPackage() {}
	
	// create pointcut for getter methods
	@Pointcut("execution(* com.omerbguclu.aopdemo.dao.*.get*(..))")
	private void getter() {}
	
	// create pointcut for setter methods
	@Pointcut("execution(* com.omerbguclu.aopdemo.dao.*.set*(..))")
	private void setter() {}
	
	// create point: include package ... exclude getter/setter
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	private void forDaoPackageNoGetterSetter() {}
	
	@Before("getter()")
	public void beforeGetterAdvice() {
		System.out.println("1----> Executing @Before advice on method getter*()");
	}
	
	@Before("setter()")
	public void beforeSetterAdvice() {
		System.out.println("2----> Executing @Before advice on method setter*()");
	}
	
	@Before("forDaoPackageNoGetterSetter()")
	public void beforeDaoPackageNoGetterSetter() {
		System.out.println("3----> Executing @Before advice on method addAccount() without getter/setter s");
	}
}