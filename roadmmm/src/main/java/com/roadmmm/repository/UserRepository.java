package com.roadmmm.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.roadmmm.domain.User;

@Repository
public class UserRepository {
	@PersistenceContext
	private EntityManager em;
	
	public void insertUser(User user) {
		em.persist(user);
	}
	
	public User selectUser_id(long user_id) {
		User user = em.find(User.class, user_id);
		
		return user;
	}
	
	public User selectUserid(String userid) {
		List<User> user = new ArrayList<User>();
		
		user = em.createQuery("select u from User u where userid = :userid", User.class)
				.setParameter("userid", userid)
				.getResultList();
		
		if(user.get(0) == null) {
			return null;
		}
		
		return user.get(0);
	}
}
