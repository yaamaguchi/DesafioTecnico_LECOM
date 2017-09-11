package com.teste.controller;

import java.io.IOException;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.teste.DAO.ServicosDAO;
import com.teste.model.Servicos;


@Path("/cliente")
public class ServicosService {
	private ServicosDAO sDao = new ServicosDAO();
	

    @GET
    @Path("/servicos")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsers(){
    	return Response.ok(sDao.getAllServicos()).build();
    }
    
    @GET
    @Path("/servico/{clienteid}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getServicosByClienteId(@PathParam(value="clienteid")Long idCliente){
    	return Response.ok(sDao.getServicosByClienteID(idCliente)).build();
    }

    @GET
    @Path("/{servicoid}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getServicoId(@PathParam("servicoid") Long idServico){
    	Servicos s = sDao.getServicoById(idServico);
    	return Response.ok(s).build();
    }
    
    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createCliente(Servicos servico) throws IOException{
    	if(servico != null){
    		sDao.registerServico(servico);
    		return Response.ok(servico).build();
    	}
    	return Response.noContent().build();
    }
    
    @DELETE
    @Path("/removeservico")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response removeServico(Servicos servico) throws IOException{
    	if(servico != null){
    		sDao.deleteServico(servico);
    		return Response.ok().build();
    	}
    	return Response.noContent().build();
    }
    
}
