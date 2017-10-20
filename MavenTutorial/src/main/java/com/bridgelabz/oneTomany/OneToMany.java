package com.bridgelabz.oneTomany;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class OneToMany {
	
	private static SessionFactory factory;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration configuration=new Configuration().configure("com/bridgelabz/oneTomany/hibernate.cfg.xml");
		factory=configuration.buildSessionFactory();
		Session session=factory.openSession();
		Transaction transaction=session.beginTransaction();
		Stadium stadium=new Stadium();
		stadium.setCapacity(2300);
		stadium.setName("Sydney");
		stadium.setCountry("Australia");
		
		CricketMatch match1=new CricketMatch();
		match1.setTeam1("India");
		match1.setTeam2("Australia");
		match1.setType("Test Match");
		match1.setUmpire("Billy Bowden");
		
		CricketMatch match2=new CricketMatch();
		match2.setTeam1("West Indies");
		match2.setTeam2("South Africa");
		match2.setType("T 20");
		match2.setUmpire("Stuart Willy");
		
		Set<CricketMatch> matches=new HashSet<CricketMatch>();
		matches.add(match1);
		matches.add(match2);
		stadium.setMatches(matches);
		session.save(match1);
		session.save(match2);
		int stadiumId=(Integer) session.save(stadium);
		transaction.commit();
		session.close();
		getStadiumDetails(stadiumId);
		factory.close();
	}
	
	public static void getStadiumDetails(int id) {
		// TODO Auto-generated method stub
		Session session=factory.openSession();
		Stadium stadium=session.get(Stadium.class, id);
		Set<CricketMatch> matches=stadium.getMatches();
		System.out.println(matches);
		System.out.println(stadium);
	}

}
