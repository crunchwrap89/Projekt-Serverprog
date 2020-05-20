package dataaccess;

import java.util.List;
import javax.ejb.Local;

import domain.User;

@Local
public interface UserDataAccess {
	public  void insert(User newUser);
	public  List<User> findAll();
	public  List<User> findBySurname(String surname);

}


