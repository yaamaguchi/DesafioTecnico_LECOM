package com.teste.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONObject;

import com.teste.DAO.ClienteDAO;
import com.teste.model.Cliente;

@Path("/cliente")
public class ClienteService {
	ClienteDAO cDao = new ClienteDAO();
	
	@GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public String enter(){
       return "Entrou";
    }

    @GET
    @Path("/clientes")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsers(){
    	
    	return Response.ok(JSONObject.valueToString(cDao.getAllClientes())).build();
    }

    @GET
    @Path("/clientes/{clienteid}")
    @Produces(MediaType.APPLICATION_JSON)
    public Cliente getUser(@PathParam("userid") Long idCliente){
       return cDao.getClienteByID(idCliente);
    }
/*
   @POST
   @Path("/users")
   @Consumes(MediaType.APPLICATION_JSON)
   public String createCliente(JSONObject json) throws IOException{
	  Cliente user = new Cliente(id, name, profession);
	  String cliente = (String)json.get("input");
	  
   }

   @PUT
   @Path("/users")
   @Produces(MediaType.APPLICATION_XML)
   @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
   public String updateUser(@FormParam("id") int id,
      @FormParam("name") String name,
      @FormParam("profession") String profession,
      @Context HttpServletResponse servletResponse) throws IOException{
	   Cliente user = new Cliente(id, name, profession);
      int result = userDao.updateUser(user);
      if(result == 1){
         return SUCCESS_RESULT;
      }
      return FAILURE_RESULT;
   }

   @DELETE
   @Path("/users/{userid}")
   @Produces(MediaType.APPLICATION_XML)
   public String deleteUser(@PathParam("userid") int userid){
      int result = userDao.deleteUser(userid);
      if(result == 1){
         return SUCCESS_RESULT;
      }
      return FAILURE_RESULT;
   }

   @OPTIONS
   @Path("/users")
   @Produces(MediaType.APPLICATION_XML)
   public String getSupportedOperations(){
      return "<operations>GET, PUT, POST, DELETE</operations>";
   	}*/
}
