package com.roadmmm.repository;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
	
	public List<PopularLive> selectPopularLives(){
		
		List<PopularLive> popularLives = em.createQuery("select p from PopularLive p", PopularLive.class)
				.getResultList();
		
		return popularLives;
	}
	
	public StockStudy selectPopularLiveListInfo(PopularLive popularLive) {
		
		Long pId = popularLive.getBoardId();
		
		System.out.println("pId : " + pId);
		
		List<StockStudy> stockStudys = new ArrayList<StockStudy>();
		
		stockStudys = em.createQuery("select s from StockStudy s WHERE s.id = :pid", StockStudy.class)
				.setParameter("pid", pId)
				.getResultList();
			

		return stockStudys.get(0);
		
	}
	
	public List<PopularLive> selectPopularDays(String dayStart, String dayEnd) {
		//jsql문법 확인 필
		List<PopularLive> popularDays = em.createQuery("select p from PopularLive p WHERE p.date BETWEEN {ts :daystart} AND {ts :dayend} ", PopularLive.class)
				.setParameter("daystart", dayStart)
				.setParameter("datend", dayEnd)
				.getResultList();
		
		return popularDays;
		
	}
	
}
