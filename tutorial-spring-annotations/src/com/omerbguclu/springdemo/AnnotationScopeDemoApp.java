package com.omerbguclu.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationScopeDemoApp {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Coach theCoach = context.getBean("tennisCoach",Coach.class);
		Coach theSillyCoach = context.getBean("tennisCoach",Coach.class);
		
		System.out.println("theCoach memory -> "+theCoach);
		System.out.println("theSillyCoach memory -> "+theSillyCoach);
		
		context.close();
	}
}
