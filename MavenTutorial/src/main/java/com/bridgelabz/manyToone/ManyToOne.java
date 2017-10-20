package com.bridgelabz.manyToone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ManyToOne {
	
	private static SessionFactory factory;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Configuration configuration=new Configuration().configure("com/bridgelabz/manyToone/hibernate.cfg.xml");
		factory=configuration.buildSessionFactory();
		Session session=factory.openSession();
		Transaction transaction=session.beginTransaction();
		Stadium stadium=new Stadium();
		stadium.setName("Sydney");
		stadium.setCapacity(2300);
		stadium.setCountry("Australia");
		
		CricketMatch cricketMatch=new CricketMatch();
		cricketMatch.setTeam1("India");
		cricketMatch.setTeam2("Australia");
		cricketMatch.setType("Test Match");
		cricketMatch.setUmpire("Billy Bowden");
		cricketMatch.setStadium(stadium);
		
		session.save(stadium);
		int matchId=(Integer) session.save(cricketMatch);
		transaction.commit();
		session.close();
		getMatchDetails(matchId);
		factory.close();
	}
	
	public static void getMatchDetails(int id) {
		
		Session session=factory.openSession();
		CricketMatch cricketMatch=session.get(CricketMatch.class, id);
		Stadium stadium=cricketMatch.getStadium();
		System.out.println(cricketMatch);
		System.out.println(stadium);
	}

}
