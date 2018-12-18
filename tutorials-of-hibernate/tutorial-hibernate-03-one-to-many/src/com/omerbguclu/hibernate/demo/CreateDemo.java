package com.omerbguclu.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.omerbguclu.hibernate.demo.entity.Instructor;
import com.omerbguclu.hibernate.demo.entity.InstructorDetail;

public class CreateDemo {
	public static void main(String[] args) {
		//create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();		
		//create session
		Session session = factory.getCurrentSession();
		try {
			// create the objects
			Instructor tempInstructor = new Instructor("Omer","Beg","omerbguclu@gmail.com");
			InstructorDetail tempInstructorDetail = 
					new InstructorDetail("http://www.luv2code.com/youtube","Luv 2 Code!!!");
			
			// associate the objects
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			
			//start a transaction
			session.beginTransaction();

			// save the instructor
			System.out.println("Saving instructor: " + tempInstructor);
			session.save(tempInstructor);
			
			//commit the transaction
			session.getTransaction().commit();
			System.out.println("Done!");
		} finally {
			factory.close();
		}
	}
}