package com.teste.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.teste.model.Classificacao;

public class ClassificacaoDAO {
	private static EntityManager em;
	private static ClassificacaoDAO init;
	
	
	private ClassificacaoDAO(){}
	
	public static ClassificacaoDAO iniciarClassificacao(){
		if(init == null){
			init = new ClassificacaoDAO();
			em = Init.getInstancia().getManager();
			em.getTransaction().begin();
			Classificacao cOuro = new Classificacao("Ouro", 0.1);
			Classificacao cPrata = new Classificacao("Prata", 0.05);
			
			em.persist(cOuro);
			em.persist(cPrata);
			em.getTransaction().commit();
		}
		return init;
	}
	
	
	public Classificacao getClassificacao (String tipo){
		TypedQuery<Classificacao> query =
			      em.createQuery("SELECT c"
			      		+ "		  FROM Classificacao c"
			      		+ "		  WHERE c.descricao='"+tipo+"'",
			      	Classificacao.class);
		List<Classificacao> results = new ArrayList<Classificacao>();
		try{
			results = query.getResultList();
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}finally{
			if(results.size() == 1)
				return results.get(0);
		}
		return null;
	}
}
