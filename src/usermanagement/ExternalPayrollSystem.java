package usermanagement;

import javax.ejb.Stateless;

import domain.User1;

@Stateless
public class ExternalPayrollSystem {
	public void enrollUser(User1 newUser) throws
	ServiceUnavailableException {
	double test = Math.random();
	if (test < 0.5) {
	throw new ServiceUnavailableException();
	}
	else {
	//do some processing
	}
	}
}


