package usermanagement;

import java.util.List;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.inject.Inject;

import usermanagement.ExternalPayrollSystem;

import dataaccess.UserDataAccess;
import domain.User1;


@Stateless
public class UserManagementImplementation implements UserManagementService, UserManagementServiceLocal {
	
	@Inject
	private UserDataAccess dao;
	
	@Inject
	private ExternalPayrollSystem payrollSystem;
	
	@Resource
	private SessionContext ctx;
	
	@Override
	public void registerUser(User1 user) {
		dao.insert(user);
		//payrollSystem.enrollUser(user);

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
	public User1 getById(int id) {
		return dao.findById(id);
	}
	
}
