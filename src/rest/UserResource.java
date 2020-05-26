package rest;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import dataaccess.UserNotFoundException;
import domain.User1;
import usermanagement.ServiceUnavailableException;
import usermanagement.UserManagementServiceLocal;

@Stateless
@Path("/users")
public class UserResource {
	
	@Inject
	private UserManagementServiceLocal service;
	
	@GET
	@Produces("application/XML")
	public List<User1> getAllUsers() {
		return service.getAllUsers();
	}
	
	@GET
	@Produces("application/XML")
	@Path("{userNo}")
	public Response findUserById(@PathParam("userNo") int id) {
		try {
			User1 result = service.getById(id);
			return Response.ok(result).build(); 
		} catch (UserNotFoundException e) {
			return Response.status(404).build();
		}
	}
	
	@POST
	@Produces("application/XML")
	@Consumes("application/XML")
	public User1 createUser(User1 user) {
		try {
			service.registerUser(user);
		} catch (ServiceUnavailableException e) {
			System.out.println("Något gick fel, rollback har initierats");
			e.printStackTrace();
		}
		return user;
	}
	
	@PUT
	@Produces("application/XML")
	@Consumes("application/XML")
	@Path("{userNo}")
	public Response updateUser(@PathParam("userNo") int id, User1 user) {
		try {
			service.updateUser(id, user.getName(), user.getSurname());
			return Response.ok(service.getById(id)).build();
		} catch (UserNotFoundException e) {
			return Response.status(404).build();
		}
		
	}
	
	@DELETE
	@Path("{userNo}")
	public Response deleteUser(@PathParam("userNo") int id) {
	    try {
	        service.deleteUser(id);
	        return Response.status(204).build();
	    } catch (UserNotFoundException e) {
	        return Response.status(404).build();
	    }
	}
}
