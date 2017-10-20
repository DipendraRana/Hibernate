package com.bridgelabz.Delete;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DeleteObject {
	
	public static void main(String args[]) {
		
		Configuration configuration=new Configuration().configure("com/bridgelabz/Delete/hibernate.cfg.xml");
		SessionFactory factory=configuration.buildSessionFactory();
		Session session=factory.openSession();
		Transaction transaction=session.beginTransaction();
		Account account=session.get(Account.class, 1);
		session.delete(account);
		transaction.commit();
		factory.close();
	} 

}
