package dataaccess;

import java.util.List;
import javax.ejb.Local;

import domain.User1;

@Local
public interface UserDataAccess {
	public  void insert(User1 newUser);
	public  List<User1> findAll();
	public  List<User1> findBySurname(String surname);
	public User1 findById(int id);

}


