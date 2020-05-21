package rest;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import com.sun.xml.internal.ws.wsdl.writer.document.Service;

import domain.User;
import usermanagement.UserManagementServiceLocal;

@Stateless
@Path("/users")
public class UserResource {
	
	@Inject
	private UserManagementServiceLocal service;
	
	@GET
	public List<User> getAllUsers() {
		return service.getAllUsers();
	}
}
