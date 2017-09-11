package com.teste.controller;

import java.io.IOException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.teste.DAO.ClienteDAO;
import com.teste.model.Cliente;
import com.teste.model.Servicos;

@Path("/cliente")
public class ClienteService {
	ClienteDAO cDao = new ClienteDAO();
	
	@GET
    @Path("/")
    @Produces(MediaType.TEXT_HTML)
    public String enter(){
       return "Entrou";
    }

    @GET
    @Path("/clientes")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsers(){
    	return Response.ok(cDao.getAllClientes()).build();
    }

    @GET
    @Path("/{userid}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUser(@PathParam("userid") Long idCliente){
    	Cliente c = cDao.getClienteByID(idCliente);
    	return Response.ok(c).build();
    }
    
    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createCliente(Cliente cliente) throws IOException{
    	if(cliente != null){
    		cDao.registerCliente(cliente);
    		return Response.ok(cliente).build();
    	}
    	return Response.noContent().build();
    }
    
    @POST
    @Path("/updatecliente")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response alterCliente(Cliente cliente, @HeaderParam(value="idCliente")Long idCliente) throws IOException{
    	if(cliente != null){
    		cDao.updateCliente(cliente, cDao.getClienteByID(idCliente));
    		return Response.ok(cliente).build();
    	}
    	return Response.noContent().build();
    }
    
    @POST
    @Path("/removecliente")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response alterCliente(Cliente cliente) throws IOException{
    	if(cliente != null){
    		cDao.deleteCliente(cliente);
    		return Response.ok().build();
    	}
    	return Response.noContent().build();
    }
    
    @POST
    @Path("/addservico")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addServico(Servicos servico, @HeaderParam(value="idCliente")Long idCliente) throws IOException{
    	if(servico != null){
    		Cliente c = cDao.getClienteByID(idCliente);
    		cDao.addServico(c, servico);
    		return Response.ok(c).build();
    	}
    	return Response.noContent().build();
    }
}
