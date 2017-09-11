package com.teste.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
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
			Query query = em.createQuery("SELECT c FROM Classificacao c");
			List<Classificacao> lista = query.getResultList();
			if(lista.size() == 2){
				for(Classificacao c : lista){
					if(c.getDescricao().equalsIgnoreCase("ouro") ||
						c.getDescricao().equalsIgnoreCase("prata")){
							return init;
					}
				}
			}
			else if(lista.isEmpty()){
				Classificacao Ouro = new Classificacao("Ouro", 0.1);
				Classificacao Prata = new Classificacao("Prata", 0.05);
				em.persist(Ouro);
				em.persist(Prata);
				em.getTransaction().commit();
			}
		}
		return init;
	}
	
	public boolean verificarDados(){
		Classificacao cOuro = getClassificacao("ouro");
		Classificacao cPrata = getClassificacao("prata");
		if(cOuro == null && cPrata == null)
			return true;
		
		return false;
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
			if(results.size() == 1)
				return results.get(0);
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		return null;
	}
}
