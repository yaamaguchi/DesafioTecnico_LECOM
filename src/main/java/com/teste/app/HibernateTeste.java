package com.teste.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateTeste {
	private static SessionFactory factory; 
	public static void main(String args[]){
		factory = new Configuration().configure().buildSessionFactory();
		
		Session session = factory.openSession();
		Transaction tx = null;
		System.out.println(session.isConnected());
	
	}
}
