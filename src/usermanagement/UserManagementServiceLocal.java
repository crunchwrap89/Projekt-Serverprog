package usermanagement;

import java.util.List;

import javax.ejb.Local;

import domain.User;

@Local
public interface UserManagementServiceLocal {

	public void registerUser(User user) throws ServiceUnavailableException;

	public List<User> getAllUsers();

	public List<User> searchByUsername(String username);
	
	public User getById(int id);

}
