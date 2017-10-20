package com.bridgelabz.read;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class LoadUserName {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Configuration configuration=new Configuration().configure("com/bridgelabz/savingObject/hibernate.cfg.xml");
		SessionFactory factory=configuration.buildSessionFactory();
		Session session=factory.openSession();
		System.out.println("Fetching data with id 1");
		Accounts account=session.load(Accounts.class, 1);
		System.out.println(account);
		System.out.println("User Name: "+account.getUserName());
		System.out.println("Password: "+account.getPassword());
		System.out.println();
		System.out.println("Fetching data with id 4");
		account=session.load(Accounts.class, 4);
		System.out.println(account);
		System.out.println("User Name: "+account.getUserName());
		System.out.println("Password: "+account.getPassword());
		System.out.println();
	}

}
