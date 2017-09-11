package com.teste.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import com.teste.model.Cliente;
import com.teste.model.Servicos;

public class ServicosDAO {

	EntityManager em;
	EntityTransaction trns;
	
	public ServicosDAO(){
		this.em = Init.getInstancia().getManager();
	}
	
	public List<Servicos> getAllServicos(){
		TypedQuery<Servicos> query =
			      em.createQuery("SELECT s FROM Servicos s", com.teste.model.Servicos.class);
		List<Servicos> results=new ArrayList<Servicos>();
		try{
			results = query.getResultList();
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		return results;
	}
	
	public Servicos getServicosByClienteID(Long id){
		TypedQuery<Servicos> query =
			      em.createQuery("SELECT s,c FROM Servicos s"
			      		+ "		  INNER JOIN Cliente c "
			      		+ "		  WHERE c.id ="+id, com.teste.model.Servicos.class);
		
		List<Servicos> results=new ArrayList<Servicos>();
		try{
			results = query.getResultList();
			if(results.size()==1){
				return results.get(0);
			}
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		return null;
	}
	
	
	public Servicos getServicoById(Long id){
		TypedQuery<Servicos> query =
			      em.createQuery("SELECT s FROM Servicos s WHERE s.id ="+id, com.teste.model.Servicos.class);
		List<Servicos> results=new ArrayList<Servicos>();
		try{
			results = query.getResultList();
			if(results.size()==1){
				return results.get(0);
			}
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		return null;
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
