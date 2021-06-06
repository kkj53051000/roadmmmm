package com.roadmmm.repository.stockstudy;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.roadmmm.domain.stockstudy.StockStudy;
import com.roadmmm.domain.stockstudy.StockStudyTag;

@Repository
public class StockStudyRepository {
	@PersistenceContext
	EntityManager em;
	
	public void insertStockStudy(StockStudy stockStudy) {
		em.persist(stockStudy);
	}
	
	public List<StockStudy> selectStockStduys(int start){
		
		TypedQuery<StockStudy> query = em.createQuery("select s FROM StockStudy s join fetch s.user order by s.id desc", StockStudy.class);
		
		query.setFirstResult(start);
		query.setMaxResults(10);
		
		List<StockStudy> stockStduys = query.getResultList();
		
		return stockStduys;
		
	}
	
	public List<StockStudy> selectStockStduysAn(StockStudyTag tag, int start){
		
		TypedQuery<StockStudy> query = em.createQuery("select s FROM StockStudy s join fetch s.user WHERE s.tag = :tag ORDER BY s.id desc", StockStudy.class);
		
		query.setParameter("tag", tag);
		query.setFirstResult(start);
		query.setMaxResults(10);
		
		List<StockStudy> stockStduys = query.getResultList();
		
		return stockStduys;
		
	}
	
	public List<StockStudy> selectStockStduyBests(int start){
		
		TypedQuery<StockStudy> query = em.createQuery("select s From StockStudy s join fetch s.user WHERE s.bestCheck = true ORDER BY s.id desc", StockStudy.class);
		
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
	
	/*
	public int selectStockStudyBestCount(int standard) {
		
		Query countQuery = em.createQuery("select count(s) From StockStudy s WHERE s.upCount > :standard");
		
		countQuery.setParameter("standard", standard);
		
		long count = (Long)countQuery.getSingleResult();
		
		int countInt = (int)count;
		
		return countInt;
	}
	*/
	
	public int selectStockStudyBestCount() {
		
		Query countQuery = em.createQuery("select count(s) From StockStudy s WHERE s.bestCheck = :bestCheck");
		
		countQuery.setParameter("bestCheck", true);
		
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
	
	public StockStudy selectStockStudy(long ssId) {
		StockStudy stockStudy = em.find(StockStudy.class, ssId);
		
		return stockStudy;
	}
	
	public void deleteStockStudy(long ssId) {
		StockStudy stockStudy = em.find(StockStudy.class, ssId);
		
		em.remove(stockStudy);
	}
	
	public void alertStockStudyUpCount(long ssId) {
		StockStudy stockStudy = em.find(StockStudy.class, ssId);
		
		int changeCount = stockStudy.getUpCount() + 1;
		
		stockStudy.setUpCount(changeCount);
	}
	
	public void alertStockStudyDownCount(long ssId) {
		StockStudy stockStudy = em.find(StockStudy.class, ssId);
		
		int changeCount = stockStudy.getDownCount() + 1;
		
		stockStudy.setDownCount(changeCount);
	}
	
	public void alertStockStudyBestCheck(long ssId) {
		StockStudy stockStudy = em.find(StockStudy.class, ssId);
		
		stockStudy.setBestCheck(true);
	}
}
