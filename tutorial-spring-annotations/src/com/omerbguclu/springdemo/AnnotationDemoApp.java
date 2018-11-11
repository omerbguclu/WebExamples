package com.omerbguclu.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {

	public static void main(String[] args) {
		// read spring config file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		// get the bean from spring container
		Coach theCoach = context.getBean("tennisCoach", Coach.class);
		Coach footballCoach = context.getBean("footballCoach", Coach.class);
		SwimCoach swimCoach = context.getBean("swimCoach", SwimCoach.class);

		// call a method on the bean
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyFortune());
		System.out.println(footballCoach.getDailyWorkout());
		System.out.println(footballCoach.getDailyFortune());
		System.out.println(swimCoach.getDailyFortune());
		System.out.println(swimCoach.getDailyWorkout());
		System.out.println(swimCoach.getEmail());
		System.out.println(swimCoach.getTeam());
		// close the context
		context.close();

	}
}
