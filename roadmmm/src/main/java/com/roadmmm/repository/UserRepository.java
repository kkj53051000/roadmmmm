package com.roadmmm.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.roadmmm.domain.User;
import com.roadmmm.domain.UserSubNickname;

@Repository
public class UserRepository {
	@PersistenceContext
	private EntityManager em;
	
	public void insertUser(User user) {
		em.persist(user);
	}
	
	public User selectUser_id(long userId) {
		User user = em.find(User.class, userId);
		
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
	
	public void insertUserSubNickname(long userId, UserSubNickname subNickname) {
		
		User user = em.find(User.class, userId);
		
		user.setSubNickname(subNickname);
	}
}
