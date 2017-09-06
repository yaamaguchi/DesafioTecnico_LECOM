package com.teste.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Init {
	private EntityManagerFactory emf;
	private static Init instancia;
	
	private Init(){}
	
	public static Init getInstancia(){
		if(instancia == null){
			instancia = new Init();
			instancia.emf = Persistence.createEntityManagerFactory("DesafioJPA");
		}
		return instancia;
	}
	public EntityManager getManager(){
		return emf.createEntityManager();
	}
	
	public EntityTransaction getManagerTransaction(){
		EntityManager em = this.emf.createEntityManager();
		return em.getTransaction();
	}
}
