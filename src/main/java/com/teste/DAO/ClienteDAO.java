package com.teste.DAO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import com.teste.model.Classificacao;
import com.teste.model.Cliente;
import com.teste.model.Servicos;
import com.teste.util.DatesCompare;

public class ClienteDAO {
	EntityManager em;
	EntityTransaction trns;
	
	public ClienteDAO(){
		this.em = Init.getInstancia().getManager();
	}
	
	public List<Cliente> getAllClientes(){
		
		TypedQuery<Cliente> query =
			      em.createQuery("SELECT c FROM Cliente c", Cliente.class);
		List<Cliente> results=new ArrayList<Cliente>();
		try{
			results = query.getResultList();
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		return results;
	}
	
	public Cliente getClienteByID(Long id){
		Cliente c = null;
		try{
			c = em.find(Cliente.class, id);
		}catch(Exception ex){
			System.out.print(ex.getMessage());
		}
		return c;
	}
	
	public Cliente registerCliente(Cliente c, String tipo){
		this.trns = em.getTransaction();
		this.trns.begin();
		try{
			c.setClassificacao(ClassificacaoDAO.iniciarClassificacao().getClassificacao(tipo));
			this.em.persist(c);
			this.trns.commit();
		}catch(Exception ex){
			System.out.println(ex);
		}
		return c;
	}
	
	public Cliente updateCliente(Cliente cAtualizar, String tipo, Cliente cAntigo){
		Cliente cAux = em.find(Cliente.class, cAntigo.getId());
		this.trns = em.getTransaction();
		this.trns.begin();
		cAux.setClassificacao(ClassificacaoDAO.iniciarClassificacao().getClassificacao(tipo));
		cAux.setNome(cAtualizar.getNome());
		try{
			this.trns.commit();
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		return cAux;
	}
	
	public Cliente addServico(Cliente c, Servicos s){
		Cliente cx = getClienteByID(c.getId());
		Servicos sx = em.find(Servicos.class, s.getId());
		if(cx != null && sx != null){
			this.trns = em.getTransaction();
			this.trns.begin();
			try{
				double value = sx.getValor()*(1-cx.getClassificacao().getValor());
				Date dAtual = new Date();
				DatesCompare st = new DatesCompare();
				
				if(st.differDates(sx.getDataFim(), dAtual) < 10)
					value = value*0.95;
				
				sx.setValorFinal(value);
				cx.getListaServicos().add(sx);
				this.trns.commit();
			}catch(Exception ex){
				System.out.println(ex.getMessage());
			}
			return cx;
		}
		return null;
	}
	
	public void deleteCliente(Cliente c){
		Cliente aux = em.find(Cliente.class, c.getId());
		this.trns = em.getTransaction();
		this.trns.begin();
		try{
			em.remove(aux);
			this.trns.commit();
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	}
}
