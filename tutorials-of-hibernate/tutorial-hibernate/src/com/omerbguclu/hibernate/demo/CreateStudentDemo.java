package com.omerbguclu.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.omerbguclu.hibernate.demo.entity.Student;

public class CreateStudentDemo {
	public static void main(String[] args) {
		//create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();		
		//create session
		Session firstSession = factory.getCurrentSession();
		try {
			//use the session object to save Java object
			System.out.println("Creating a new student object");			
			//create a student object
			Student tempStudent = new Student("Omer","Bey","omerbey@gmail.com");			
			//start a transaction
			firstSession.beginTransaction();
			//save the student object
			System.out.println("Saving the student...");
			firstSession.save(tempStudent);
			//commit the transaction
			firstSession.getTransaction().commit();
			System.out.println("Done!");
		} finally {
			factory.close();
		}
	}
}