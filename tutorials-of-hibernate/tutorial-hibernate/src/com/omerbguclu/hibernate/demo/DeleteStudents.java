package com.omerbguclu.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.omerbguclu.hibernate.demo.entity.Student;

public class DeleteStudents {
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
			System.out.println("Updating student object with id number:3");
			//delete a student object
			firstSession.createQuery("delete from Student where id=3").executeUpdate();			
			//commit the transaction
			firstSession.getTransaction().commit();
			System.out.println("Done!");
			
			//another way
			firstSession=factory.getCurrentSession();
			firstSession.beginTransaction();
			Student tempStudent = firstSession.get(Student.class, id);
			firstSession.delete(tempStudent);
			firstSession.getTransaction().commit();
			System.out.println("done!");
		} finally {
			factory.close();
		}
	}

}
