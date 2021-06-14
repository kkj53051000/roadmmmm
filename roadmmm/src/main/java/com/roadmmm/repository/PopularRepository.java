package com.roadmmm.repository;


import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.roadmmm.domain.PopularLive;
import com.roadmmm.domain.stockstudy.StockStudy;

@Repository
public class PopularRepository {
	@PersistenceContext
	private EntityManager em;
	
	public void insertPopularLive(PopularLive popularLive) {
		em.persist(popularLive);
	}
	
	public int selectPopularLiveCount() {
		Query countQuery = em.createQuery("select count(p) From PopularLive p");
		
		long count = (Long)countQuery.getSingleResult();
		
		int countInt = (int)count;
		
		return countInt;
	}
	
	public List<PopularLive> selectPopularLives(int start){
		
		TypedQuery<PopularLive> query = em.createQuery("select p From PopularLive p", PopularLive.class);
		
		query.setFirstResult(start);
		query.setMaxResults(10);
		
		List<PopularLive> popularLives = query.getResultList();
		
		return popularLives;
	}
	
	public int selectPopularDayCount(Date dayStart, Date dayEnd) {
		Query countQuery = em.createQuery("select count(p) From PopularLive p WHERE p.date BETWEEN :dayStart AND :dayEnd");
		
		countQuery.setParameter("dayStart", dayStart);
		countQuery.setParameter("dayEnd", dayEnd);
		
		
		long count = (Long)countQuery.getSingleResult();
		
		int countInt = (int)count;
		
		return countInt;
	}
	
	public List<PopularLive> selectPopularDays(Date dayStart, Date dayEnd, int start) {
		//jsql문법 확인 필
//		List<PopularLive> popularDays = em.createQuery("select p from PopularLive p WHERE p.date BETWEEN :dayStart AND :dayend", PopularLive.class)
//				.setParameter("dayStart", dayStart)
//				.setParameter("dayend", dayEnd)
//				.getResultList();
		
		TypedQuery<PopularLive> query = em.createQuery("select p from PopularLive p WHERE p.date BETWEEN :dayStart AND :dayEnd", PopularLive.class);
		
		query.setParameter("dayStart", dayStart);
		query.setParameter("dayEnd", dayEnd);
		query.setFirstResult(start);
		query.setMaxResults(10);
		
		List<PopularLive> popularDays = query.getResultList();
		
		return popularDays;
		
	}
	
	public List<PopularLive> selectPopularMonths(Date monthStart, Date monthEnd){
		List<PopularLive> popularMonths = em.createQuery("select p from PopularLive p WHERE p.date BETWEEN :monthStart AND :monthEnd", PopularLive.class)
				.setParameter("monthStart", monthStart)
				.setParameter("monthEnd", monthEnd)
				.getResultList();
		
		System.out.println("list size : " + popularMonths.size());
		
		return  popularMonths;
	}
	
}
