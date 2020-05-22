package dataaccess;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import domain.User1;


@Stateless
@Default
@ProductionDao
public class UserDataAccessProductionVersion implements UserDataAccess {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void insert(User1 newUser) {
		em.persist(newUser);
	}

	@Override
	public List<User1> findAll() {
		Query q = em.createQuery("select user1 from User1 user1");
		List<User1> users = q.getResultList();
		return users;
	}

	@Override
	public List<User1> findBySurname(String surname) {
		Query q = em.createQuery("select user1 from User1 user1 where user1.surname = :surname");
		q.setParameter("surname", surname);
		return q.getResultList();
	}
	
	@Override
	public User1 findById(int id) {
		Query q = em.createQuery("select user1 from User1 user1 where user1.id = :id");
		q.setParameter("id", id);
		return (User1)q.getSingleResult() ;
	}


}
