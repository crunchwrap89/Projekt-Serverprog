package rest;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.sun.xml.internal.ws.wsdl.writer.document.Service;

import domain.User;
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
}
