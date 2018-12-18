package com.omerbguclu.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.omerbguclu.hibernate.demo.entity.Course;
import com.omerbguclu.hibernate.demo.entity.Instructor;
import com.omerbguclu.hibernate.demo.entity.InstructorDetail;
import com.omerbguclu.hibernate.demo.entity.Review;
import com.omerbguclu.hibernate.demo.entity.Student;

public class CreateCourseAndStudentsDemo {
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

			// create a course
			Course tempCourse = new Course("Pacman - How To Score One Miliion Points");			

			// create the students 
			Student tempStudent1 = new Student("John","Doe", "johndoe@gmail.com");
			Student tempStudent2 = new Student("Marry","Public", "marypublic@gmail.com");
			
			// add the students to the course
			tempCourse.addStudent(tempStudent1);
			tempCourse.addStudent(tempStudent2);
			
			// save the students
			System.out.println("\n Saving students ...");
			session.save(tempStudent1);
			session.save(tempStudent2);
			System.out.println("Saved students: " + tempCourse.getStudents());
			
			// save the course ... and leverage the cascade all 
			System.out.println("Saving the course... \n"+tempCourse+"\n"+tempCourse.getStudents());
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