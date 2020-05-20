package usermanagement;

import java.util.List;

import dataaccess.UserDataAccess;
import domain.User;



public class UserManagementImplementation implements UserManagementService {
	
	private UserDataAccess dao;
	
	@Override
	public void registerUser(User user) {
		

	}

	@Override
	public List<User> getAllUsers() {
		return dao.findAll();
	}

	@Override
	public List<User> searchByUsername(String surname) {
		return dao.findBySurname(surname);
	}
	
}
