package com.bridgelabz.caching;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class SecondLevelCache {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Configuration configuration = new Configuration().configure("com/bridgelabz/caching/hibernate.cfg.xml");        
        SessionFactory factory = configuration.buildSessionFactory();
        Session session=  factory.openSession(); 

        Transaction transaction = session.beginTransaction();
        Student student = new Student();
        student.setName("Student A");
        student.setEmailAddress("a@g.com");

        int id = (Integer)session.save(student);

        transaction.commit();                
        session.close();

        session=  factory.openSession();

        Student student1 = (Student) session.get(Student.class, id);
        Student student2 = (Student) session.get(Student.class, id);
        session.close();

        session=  factory.openSession();

        Student student3 = (Student) session.get(Student.class, id);        
        session.close();        
        factory.close();        
	}

}
