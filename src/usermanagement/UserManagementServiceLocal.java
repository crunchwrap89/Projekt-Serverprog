package usermanagement;

import java.util.List;

import javax.ejb.Local;

import dataaccess.UserNotFoundException;
import domain.User1;

@Local
public interface UserManagementServiceLocal {

	public void registerUser(User1 user) throws ServiceUnavailableException;

	public List<User1> getAllUsers();

	public List<User1> searchByUsername(String username);
	
	public User1 getById(int id) throws UserNotFoundException;
	
	public void updateUser(int id, String name, String surname) throws UserNotFoundException;
	
	public void deleteUser(int id) throws UserNotFoundException;

}
