package com.bridgelabz.manyTomany;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ManyToMany {
	
	private static SessionFactory factory;   

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration confgigure = new Configuration().configure("com/bridgelabz/manyTomany/hibernate.cfg.xml");
        factory = confgigure.buildSessionFactory();        
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
  
        Role role1 = new Role();
        role1.setName("Manager");        
        Role role2 = new Role();
        role2.setName("Admin");
 
        Set<Role> roles = new HashSet<Role>();
 
        roles.add(role2);
        roles.add(role1);
  
        Employee employee = new Employee();
        employee.setName("Person A");
        employee.setRoles(roles);
 
        session.save(role1);
        session.save(role2);
 
        int empId = (Integer)session.save(employee);
 
        tx.commit();        
        session.close();
 
        getEmployeeDetails(empId);
       factory.close();        
    }
 
    private static void getEmployeeDetails(int id)
    {
        Session session = factory.openSession();        
        Employee employee = (Employee)session.get(Employee.class,id);
  
        String name= employee.getName();
        Set<Role> roles = employee.getRoles();
        System.out.println(name);
        System.out.println(roles);        
    }

}

