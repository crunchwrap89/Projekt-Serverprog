package dataaccess;

import java.util.List;
import javax.ejb.Local;


@Local
public class UserDataAccess {
	public  void insert(User newUser);
	public  List<User> findAll();
	public  List<User> findBySurname(String surname);

}


