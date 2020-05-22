package usermanagement;

import java.util.List;

import javax.ejb.Remote;

import domain.User1;

@Remote
public interface UserManagementService extends UserManagementServiceLocal {

//	public void registerUser(User user);
//	public List<User>getAllUsers();
//	public List<User>searchByUsername(String username);
}
