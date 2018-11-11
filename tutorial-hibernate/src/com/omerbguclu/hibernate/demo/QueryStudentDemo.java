package com.omerbguclu.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.omerbguclu.hibernate.demo.entity.Student;

public class QueryStudentDemo {
	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();
		// create session
		Session firstSession = factory.getCurrentSession();
		try {
			// start a transaction
			firstSession.beginTransaction();

			// query students
			List<Student> theStudents = firstSession.createQuery("from Student", Student.class).getResultList();

			// display the students
			displayStudents(theStudents);

			// query students with a specific last name
			theStudents = firstSession.createQuery("from Student s where s.lastName='bey'", Student.class)
					.getResultList();
			System.out.println("\n\nlast name with 'bey'");
			displayStudents(theStudents);

			// query students with a specific first name
			theStudents = firstSession.createQuery("from Student s where s.firstName='omer'", Student.class)
					.getResultList();
			System.out.println("\n\nname start with 'omer'");
			displayStudents(theStudents);

			// query students with a specific first name or last name
			theStudents = firstSession
					.createQuery("from Student s where s.firstName='omer' OR s.lastName='bey'", Student.class)
					.getResultList();
			System.out.println("\n\nname start with 'omer' or last name is 'bey'");
			displayStudents(theStudents);

			// query students ends with a specific words
			theStudents = firstSession.createQuery("from Student s where s.firstName LIKE '%et'", Student.class)
					.getResultList();
			System.out.println("\n\nends with 'et'");
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
