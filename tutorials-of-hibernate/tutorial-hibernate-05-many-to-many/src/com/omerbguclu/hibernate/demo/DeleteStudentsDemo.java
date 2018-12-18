package com.omerbguclu.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.omerbguclu.hibernate.demo.entity.Course;
import com.omerbguclu.hibernate.demo.entity.Instructor;
import com.omerbguclu.hibernate.demo.entity.InstructorDetail;
import com.omerbguclu.hibernate.demo.entity.Review;
import com.omerbguclu.hibernate.demo.entity.Student;

public class DeleteStudentsDemo {
	public static void main(String[] args) {
		//create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.addAnnotatedClass(Review.class)
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();		
		//create session
		Session session = factory.getCurrentSession();
		try {
			//start a transaction
			session.beginTransaction();
						
			int theStudentsId = 1;
			Student tempStudent = session.get(Student.class, theStudentsId);
			
			// delete the course
			System.out.println("Deleting student: " + tempStudent);
			session.delete(tempStudent);
			
			//commit the transaction
			session.getTransaction().commit();
			System.out.println("Done!");
		} finally {
			session.close();
			
			factory.close();
		}
	}
}