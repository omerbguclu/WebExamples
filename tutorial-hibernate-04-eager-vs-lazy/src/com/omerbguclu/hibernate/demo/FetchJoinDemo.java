package com.omerbguclu.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.omerbguclu.hibernate.demo.entity.Course;
import com.omerbguclu.hibernate.demo.entity.Instructor;
import com.omerbguclu.hibernate.demo.entity.InstructorDetail;

public class FetchJoinDemo {
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
			
			// get the instructor from database
			int theId = 1;
			
			// option 2 Hibernate query with HQL
			Query<Instructor> query = session.createQuery("select i from Instructor i "
														+ "JOIN FETCH i.courses "
														+ "where i.id=:theInstructorId",
														Instructor.class);			
			// set parameter on query
			query.setParameter("theInstructorId", theId);
			
			// execute query and get instructor
			Instructor tempInstructor = query.getSingleResult();
			
			System.out.println("Toggled: Instructor: " + tempInstructor);
						
			//commit the transaction
			session.getTransaction().commit();
			session.close();
			
			System.out.println("Toggled: Courses: " + tempInstructor.getCourses());
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