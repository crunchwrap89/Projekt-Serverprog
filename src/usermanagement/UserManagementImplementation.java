package usermanagement;

import java.util.List;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.inject.Inject;

import usermanagement.CrashSimulator;

import dataaccess.UserDataAccess;
import dataaccess.UserNotFoundException;
import domain.User1;


@Stateless
public class UserManagementImplementation implements UserManagementService, UserManagementServiceLocal {
	
	@Inject
	private UserDataAccess dao;
	
	@Inject
	private CrashSimulator payrollSystem;
	
	@Resource
	private SessionContext ctx;
	
	@Override
	public void registerUser(User1 user) throws ServiceUnavailableException {
		dao.insert(user);
//	    try {
//	        payrollSystem.enrollUser(user);
//	    }catch (ServiceUnavailableException e) {
//	        ctx.setRollbackOnly();
//	        throw e;
//	    }
	}

	@Override
	public List<User1>getAllUsers() {
		return dao.findAll();
	}

	@Override
	public List<User1> searchByUsername(String username) {
		return dao.findBySurname(username);
	}
	
	@Override
	public User1 getById(int id) throws UserNotFoundException {
		return dao.findById(id);
	}
	
	@Override
	public void updateUser(int id, String name, String surname) throws UserNotFoundException {
		dao.updateUser(id, name, surname);
	}

	@Override
	public void deleteUser(int id) throws UserNotFoundException {
		dao.deleteUser(id);
	}
	
}
