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
		
		return stockStduys;
		
	}
	
	public List<StockStudy> selectStockStduysAn(StockStudyTag tag, int start){
		
		TypedQuery<StockStudy> query = em.createQuery("select s FROM StockStudy s WHERE s.tag = :tag ORDER BY s.id desc", StockStudy.class);
		
		query.setParameter("tag", tag);
		query.setFirstResult(start);
		query.setMaxResults(10);
		
		List<StockStudy> stockStduys = query.getResultList();
		
		return stockStduys;
		
	}
	
	public int selectStockStudyCount() {
		
		Query countQuery = em.createQuery("select count(s) From StockStudy s");
		
		long count = (Long)countQuery.getSingleResult();
		
		int countInt = (int)count;
		
		return countInt;
	}
	
	public int selectStockStudtCountTag(StockStudyTag tag) {
		Query countQuery = em.createQuery("select count(s) From StockStudy s WHERE s.tag = :tag");
		
		countQuery.setParameter("tag", tag);
		
		long count = (Long)countQuery.getSingleResult();
		
		int countInt = (int)count;
		
		return countInt;
	}
	
	public StockStudy selectStockStudy(long id) {
		StockStudy stockStudy = em.find(StockStudy.class, id);
		
		return stockStudy;
	}
	
	public void deleteStockStudy(long id) {
		StockStudy stockStudy = em.find(StockStudy.class, id);
		
		em.remove(stockStudy);
	}
}
