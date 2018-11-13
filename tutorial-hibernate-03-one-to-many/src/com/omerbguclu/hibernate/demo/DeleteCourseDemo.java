package com.omerbguclu.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.omerbguclu.hibernate.demo.entity.Course;
import com.omerbguclu.hibernate.demo.entity.Instructor;
import com.omerbguclu.hibernate.demo.entity.InstructorDetail;

public class DeleteCourseDemo {
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
			//------------------------Before--------------------------------//
			//start a transaction
			session.beginTransaction();
			
			// get a course
			int theId = 12;
			Course tempCourse = session.get(Course.class, theId);
			
			System.out.println("********************Before the delete***********************");
			// delete course
			System.out.println("Deleting course: " + tempCourse);
			
			session.delete(tempCourse);
			
			//commit the transaction
			session.getTransaction().commit();
			System.out.println("Done!");
			
			//------------------------After--------------------------------//
			session = factory.getCurrentSession();
			//start a transaction
			session.beginTransaction();
			
			// get the instructor object
			theId=1;
			Instructor tempInstructor = session.get(Instructor.class, theId);
			
			System.out.println("********************After the delete***********************");			
			System.out.println("Instructor: " + tempInstructor);
			
			// get course for the instructor
			System.out.println("Courses: " + tempInstructor.getCourses());
			
			//commit the transaction
			session.getTransaction().commit();
			System.out.println("Done!");
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			//handle connection leak issue
			session.close();
			
			factory.close();
		}
	}
}