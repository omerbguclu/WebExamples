package com.omerbguclu.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.omerbguclu.hibernate.demo.entity.Course;
import com.omerbguclu.hibernate.demo.entity.Instructor;
import com.omerbguclu.hibernate.demo.entity.InstructorDetail;
import com.omerbguclu.hibernate.demo.entity.Review;

public class CreateCourseAndReviewsDemo {
	public static void main(String[] args) {
		//create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.addAnnotatedClass(Review.class)
								.buildSessionFactory();		
		//create session
		Session session = factory.getCurrentSession();
		try {
			//start a transaction
			session.beginTransaction();

			// create a course
			Course tempCourse = new Course("Pacman - How To Score One Miliion Points");
			
			// add some reviews
			tempCourse.addReview(new Review("Great Course ... Loved it!"));
			tempCourse.addReview(new Review("Cool course, job well done"));
			tempCourse.addReview(new Review("What a dumb course, you are an idiot"));
			
			// save the course ... and leverage the cascade all 
			System.out.println("Saving the course... \n"+tempCourse+"\n"+tempCourse.getReviews());
			session.save(tempCourse);
			//commit the transaction
			session.getTransaction().commit();
			System.out.println("Done!");
		} finally {
			session.close();
			
			factory.close();
		}
	}
}