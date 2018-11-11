package com.omerbguclu.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TrackJavaConfigDemoApp {
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);
		
		Coach theCoach = context.getBean("trackCoach",Coach.class);
		
		System.out.println(theCoach.getDailyFortune());
		System.out.println(theCoach.getDailyWorkout());
		context.close();
	}

}