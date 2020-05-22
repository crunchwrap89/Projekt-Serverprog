package rest;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import domain.User;
import usermanagement.ServiceUnavailableException;
import usermanagement.UserManagementServiceLocal;

@Stateless
@Path("/users")
public class UserResource {
	
	@Inject
	private UserManagementServiceLocal service;
	
	@GET
	@Produces("application/XML")
	public List<User> getAllUsers() {
		return service.getAllUsers();
	}
	
	@GET
	@Produces("application/XML")
	@Path("{userNo}")
	public User findUserById(@PathParam("UserNo") int id) {
		return service.getById(id);
	}
	
	@POST
	@Produces("application/XML")
	@Consumes("application/XML")
	public User createUser(User user) {
		try {
			service.registerUser(user);
		} catch (ServiceUnavailableException e) {
			// TODO Fix this later!
			e.printStackTrace();
		}
		return user;
	} 
}
