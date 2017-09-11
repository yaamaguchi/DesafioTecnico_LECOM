package com.teste.app;

import javax.persistence.EntityManager;

import org.hibernate.SessionFactory;

import com.teste.DAO.ClassificacaoDAO;
import com.teste.DAO.ClienteDAO;
import com.teste.DAO.Init;
import com.teste.model.Cliente;

public class HibernateTeste {
	public static void main(String args[]){
		
		EntityManager em = Init.getInstancia().getManager();
		ClassificacaoDAO.iniciarClassificacao();
		
		/*Cliente cliente1 = new Cliente("Matheus");
		Cliente cliente2 = new Cliente("MatheusTeste");
		ClienteDAO c = new ClienteDAO();
		c.registerCliente(cliente1);
		
		c.updateCliente(cliente2,cliente1);
		
		c.deleteCliente(cliente1);*/
		
	}
}
