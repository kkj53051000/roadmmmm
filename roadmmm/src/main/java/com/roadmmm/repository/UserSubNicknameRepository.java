package com.roadmmm.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.roadmmm.domain.UserSubNickname;

@Repository
public class UserSubNicknameRepository {
	@PersistenceContext
	private EntityManager em;
	
	public void insertUserSubNickname(UserSubNickname userSubNickname) {
		em.persist(userSubNickname);
	}
	
	public List<UserSubNickname> selectUserSubNicknames(){
		List<UserSubNickname> userSubNicknames = em.createQuery("select u FROM UserSubNickname u", UserSubNickname.class)
				.getResultList();
		
		return userSubNicknames;
	}
	
	public UserSubNickname selectUserSubNickname(String subNickname) {
		List<UserSubNickname> userSubNicknames = em.createQuery("select u FROM UserSubNickname u WHERE u.subNickname = :subNickname", UserSubNickname.class)
				.setParameter("subNickname", subNickname)
				.getResultList();
		
		UserSubNickname userSubNickname = userSubNicknames.get(0);
		
		return userSubNickname;
	}
}
