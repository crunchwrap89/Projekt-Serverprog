package usermanagement;

import java.util.List;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.inject.Inject;

import usermanagement.ExternalPayrollSystem;

import dataaccess.UserDataAccess;
import domain.User;


@Stateless
public class UserManagementImplementation implements UserManagementService, UserManagementServiceLocal {
	
	@Inject
	private UserDataAccess dao;
	
	@Inject
	private ExternalPayrollSystem payrollSystem;
	
	@Resource
	private SessionContext ctx;
	
	@Override
	public void registerUser(User user) {
		dao.insert(user);
		payrollSystem.enrollUser(user);

	}

	@Override
	public List<User>getAllUsers() {
		return dao.findAll();
	}

	@Override
	public List<User> searchByUsername(String username) {
		return dao.findBySurname(username);
	}
	
}
