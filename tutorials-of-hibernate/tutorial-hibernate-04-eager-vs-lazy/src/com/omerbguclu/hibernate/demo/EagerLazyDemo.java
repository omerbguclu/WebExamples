package com.omerbguclu.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.omerbguclu.hibernate.demo.entity.Course;
import com.omerbguclu.hibernate.demo.entity.Instructor;
import com.omerbguclu.hibernate.demo.entity.InstructorDetail;

public class EagerLazyDemo {
	public static void main(String[] args) {
		//create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.buildSessionFactory();		
		//create session
		Session session = factory.getCurrentSession();
		try {
			//start a transaction
			session.beginTransaction();
			
			// get the instructor object
			int theId=1;
			Instructor tempInstructor = session.get(Instructor.class, theId);
			
			System.out.println("Toggled: Instructor: " + tempInstructor);
			
			// get course for the instructor
			System.out.println("Toggled: Courses: " + tempInstructor.getCourses());
			
			//commit the transaction
			session.getTransaction().commit();
			System.out.println("Toggled: Done!");
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			//handle connection leak issue
			session.close();
			
			factory.close();
		}
	}
}