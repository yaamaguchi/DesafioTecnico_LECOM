package com.teste.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.teste.model.Cliente;
import com.teste.model.Servicos;

public class ServicosDAO {

	EntityManager em;
	EntityTransaction trns;
	
	public ServicosDAO(){
		this.em = Init.getInstancia().getManager();
	}
	
	
	public Servicos registerServico(Servicos s){
		this.trns = em.getTransaction();
		this.trns.begin();
		try{
			this.em.persist(s);
			this.trns.commit();
		}catch(Exception ex){
			System.out.println(ex);
		}
		return s;
	}
	
	
	public Servicos updateServico(Servicos sAntigo, Servicos sAtualizado){
		Servicos cAux = em.find(Servicos.class, sAntigo.getId());
		this.trns = em.getTransaction();
		this.trns.begin();
		cAux.setDataFim(sAtualizado.getDataFim());
		cAux.setDataInicio(sAtualizado.getDataInicio());
		cAux.setDescricao(sAtualizado.getDescricao());
		cAux.setValor(sAtualizado.getValor());
		try{
			this.trns.commit();
		}catch(Exception ex){
			System.out.print(ex.getMessage());
		}
		return cAux;
	}
	
	public void deleteServico(Servicos c){
		Servicos aux = em.find(Servicos.class, c.getId());
		this.trns = em.getTransaction();
		this.trns.begin();
		try{
			em.remove(aux);
			this.trns.commit();
		}catch(Exception x){
			System.out.println(x.getMessage());
		}
	}
	

}
