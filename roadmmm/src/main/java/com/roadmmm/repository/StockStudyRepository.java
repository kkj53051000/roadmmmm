package com.roadmmm.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.roadmmm.domain.StockStudy;
import com.roadmmm.domain.StockStudyTag;

@Repository
public class StockStudyRepository {
	@PersistenceContext
	EntityManager em;
	
	public void insertStockStudy(StockStudy stockStudy) {
		em.persist(stockStudy);
	}
	
	public List<StockStudy> selectStockStduys(int start){
		
		TypedQuery<StockStudy> query = em.createQuery("select s From StockStudy s order by s.id desc", StockStudy.class);
		
		query.setFirstResult(start);
		query.setMaxResults(10);
		
		List<StockStudy> stockStduys = query.getResultList();
		
		/*
		List<StockStudy> stockStduys = em.createQuery("select s From StockStudy s order by s.id desc", StockStudy.class)
				.setFirstResult(start)
				.getResultList();
		*/
		return stockStduys;
		
	}
	
	public List<StockStudy> selectStockStduysAn(StockStudyTag tag){
		
		List<StockStudy> stockStduys = em.createQuery("select s From StockStudy s where tag = :tag", StockStudy.class)
				.setParameter("tag", tag)
				.getResultList();
		
		return stockStduys;
		
	}
	
	public int selectStockStudyCount() {
		
		Query countQuery = em.createQuery("select count(s) From StockStudy s");
		
		long count = (Long)countQuery.getSingleResult();
		
		int countInt = (int)count;
		
		return countInt;
	}
}
