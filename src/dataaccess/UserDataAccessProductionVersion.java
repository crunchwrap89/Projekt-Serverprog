package dataaccess;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import domain.User;


@Stateless
@Default
@ProductionDao
public class UserDataAccessProductionVersion implements UserDataAccess {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void insert(User newUser) {
		em.persist(newUser);
	}

	@Override
	public List<User> findAll() {
		Query q = em.createQuery("select user from User user");
		List<User> users = q.getResultList();
		return users;
	}

	@Override
	public List<User> findBySurname(String surname) {
		Query q = em.createQuery("select user from User user where user.surname = :surname");
		q.setParameter("surname", surname);
		return q.getResultList();
	}
	
	@Override
	public User findById(int id) {
		Query q = em.createQuery("select user from User user where user.id = :id");
		q.setParameter("id", id);
		return (User)q.getSingleResult() ;
	}


}
