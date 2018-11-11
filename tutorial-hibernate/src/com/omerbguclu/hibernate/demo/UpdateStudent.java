package com.omerbguclu.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.omerbguclu.hibernate.demo.entity.Student;

public class UpdateStudent {
	public static void main(String[] args) {
		//create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();		
		//create session
		Session firstSession = factory.getCurrentSession();
		try {
			firstSession.beginTransaction();
			int id=1;
			//use the session object to save Java object
			System.out.println("Updating student object with id number:"+id);
			//update a student object
			Student tempStudent = firstSession.get(Student.class,id);			
			//set the student object
			tempStudent.setFirstName("Donerci");
			//commit the transaction
			firstSession.getTransaction().commit();
			System.out.println("Done!");
			
			//update all email's code's
			firstSession=factory.getCurrentSession();
			firstSession.beginTransaction();
			
			//update all email's
			System.out.println("Emails setting to foo@gmail.com");
			firstSession.createQuery("update Student set email ='foo@gmail.com'").executeUpdate();
			
			//commit the transaction
			firstSession.getTransaction().commit();
			System.out.println("Done!");
		} finally {
			factory.close();
		}
	}

}
