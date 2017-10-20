package com.bridgelabz.savingObject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class SaveMethodExample {
	
	public static void main(String args[]) {
		
		Configuration configuration=new Configuration().configure("com/bridgelabz/savingObject/hibernate.cfg.xml");
		configuration.addResource("com/bridgelabz/savingObject/account.hbm.xml");
		SessionFactory factory=configuration.buildSessionFactory();
		Session session=factory.openSession();
		Transaction transaction=session.beginTransaction();
		
		Accounts account=new Accounts();
		account.setUserName("Dipendra");
		account.setPassword("123456");
		
		session.save(account);
		account.setUserName("Ravi");
		transaction.commit();
		/*session.flush();*/
		factory.close();
	}
}
