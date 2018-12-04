package com.omerbguclu.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.omerbguclu.aopdemo.service.TrafficFortuneService;

public class AroundHandleExceptionDemoApp {

	public static void main(String[] args) {
		
		// read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from spring container
		TrafficFortuneService theFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);
		
		System.out.println("\nMain Program: AroundDemoApp\nCalling getFortune");

		boolean tripWire = true;		
		String data = theFortuneService.getFortune(tripWire);
		
		System.out.println("\nMy fortune is: " + data + "\nFinished");
		
		// close the context
		context.close();		
	}
}
