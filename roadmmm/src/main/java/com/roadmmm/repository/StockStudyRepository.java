package com.roadmmm.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
	
	public List<StockStudy> selectStockStduys(){
		
		List<StockStudy> stockStduys = em.createQuery("select s From StockStudy s", StockStudy.class)
				.getResultList();
		
		return stockStduys;
		
	}
	
	public List<StockStudy> selectStockStduysAn(StockStudyTag tag){
		
		List<StockStudy> stockStduys = em.createQuery("select s From StockStudy s where tag = :tag", StockStudy.class)
				.setParameter("tag", tag)
				.getResultList();
		
		return stockStduys;
		
	}
}
