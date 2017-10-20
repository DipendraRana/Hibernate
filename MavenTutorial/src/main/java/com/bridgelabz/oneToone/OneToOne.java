package com.bridgelabz.oneToone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class OneToOne {
	
	private static SessionFactory factory;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration configuration=new Configuration().configure("com/bridgelabz/oneToone/hibernate.cfg.xml");
		factory=configuration.buildSessionFactory();
		Session session=factory.openSession();
		Transaction transaction=session.beginTransaction();
		
		Passport passport=new Passport();
		passport.setNumber("P1");
		
		Person person=new Person();
		person.setName("Ravi");
		person.setPassport(passport);
		
		session.save(passport);
		int personID=(Integer) session.save(person);
		transaction.commit();
		session.close();
		getPersonalDetails(personID);
		factory.close();

	}
	
	public static void getPersonalDetails(int id) {
		Session session=factory.openSession();
		Person person=session.get(Person.class, id);
		Passport passport=person.getPassport();
		String name = person.getName();
        String number=passport.getNumber();
        System.out.println("Person Name =" +  name);
        System.out.println("Passport Number = " + number);
		
	}

}
