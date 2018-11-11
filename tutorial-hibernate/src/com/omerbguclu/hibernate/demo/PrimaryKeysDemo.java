package com.omerbguclu.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.omerbguclu.hibernate.demo.entity.Student;

public class PrimaryKeysDemo {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();
		// create session
		Session firstSession = factory.getCurrentSession();
		try {
			//use the session object to save Java object
			System.out.println("Creating 3 new student objects");
			//create a student object
			Student tempStudent1 = new Student("Omer", "Bey", "omerbey@gmail.com");
			Student tempStudent2 = new Student("Ahmet", "Bey", "ahmetbey@gmail.com");
			Student tempStudent3 = new Student("Mehmet", "Bey", "mehmetbey@gmail.com");
			//start a transaction
			firstSession.beginTransaction();
			//save the student object
			System.out.println("Saving the student...");
			firstSession.save(tempStudent1);
			firstSession.save(tempStudent2);
			firstSession.save(tempStudent3);
			//commit the transaction
			firstSession.getTransaction().commit();
			System.out.println("Done!");
		} finally {
			factory.close();
		}

	}
}
