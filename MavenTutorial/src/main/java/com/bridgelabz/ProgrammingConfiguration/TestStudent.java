package com.bridgelabz.ProgrammingConfiguration;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestStudent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Properties properties=new Properties();
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		properties.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
		properties.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/tutorial");
		properties.setProperty("hibernate.connection.username", "root");
		properties.setProperty("hibernate.connection.password", "root");
		properties.setProperty("hibernate.hbm2ddl.auto", "create");
		properties.setProperty("hibernate.show_sql", "true");
		properties.setProperty("hibernate.format_sql", "true");
		
		Configuration configuration=new Configuration();
		configuration.addResource("com/bridgelabz/ProgrammingConfiguration/student.hbm.xml");
		configuration.setProperties(properties);
		SessionFactory factory=configuration.buildSessionFactory();
		factory.close();

	}

}
