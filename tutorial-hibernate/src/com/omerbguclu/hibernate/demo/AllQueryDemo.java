package com.omerbguclu.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.common.util.impl.Log;
import org.hibernate.cfg.Configuration;

import com.omerbguclu.hibernate.demo.entity.Student;

public class AllQueryDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();
		// create session
		Session firstSession = factory.getCurrentSession();
		try {
			// now get a new session and start transaction
			firstSession.beginTransaction();
						
			@SuppressWarnings("unchecked")
			List<Student> theStudents = firstSession.createQuery("from Student").getResultList();

			// retrieve student based on the id: primary key
			displayStudents(theStudents);

			// commit the transaction
			firstSession.getTransaction().commit();
			System.out.println("Done!");
		} finally {
			factory.close();
		}
	}
	private static void displayStudents(List<Student> theStudents) {
		for (Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}
}
