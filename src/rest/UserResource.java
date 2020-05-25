package rest;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

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
	public User1 findUserById(@PathParam("userNo") int id) {
		return service.getById(id);
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
	public void editUser(@PathParam("userNo") int id, User1 user) {
		User1 existinguser = service.getById(id);
		if (existinguser != null) {
			service.updateUser(id, existinguser.getName(), existinguser.getSurname());
		}
		
	}
}
