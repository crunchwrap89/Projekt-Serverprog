package usermanagement;

import javax.ejb.Stateless;

import domain.User1;


@Stateless
public class CrashSimulator {
	public void enrollUser(User1 newUser) throws ServiceUnavailableException {
	
	throw new ServiceUnavailableException();
	
  }
}


