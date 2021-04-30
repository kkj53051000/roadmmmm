package com.roadmmm.repository;

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
}
