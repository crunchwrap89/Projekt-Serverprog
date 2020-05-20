package usermanagement;

import java.util.List;

import domain.User;

public interface UserManagementService {

	public void registerUser(User user);
	public List<User>getAllUsers();
	public List<User>searchByUsername(String username);
}
