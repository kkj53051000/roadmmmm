package com.roadmmm.repository.stockstudy;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.roadmmm.domain.stockstudy.StockStudyRecommend;

@Repository
public class StockStudyRecommendRepository {
	@PersistenceContext
	EntityManager em;
	
	public void insertStockStudyRecommend(StockStudyRecommend stockStudyRecommend) {
		em.persist(stockStudyRecommend);
	}
	
	public List<StockStudyRecommend> selectStockStudyRecommendList(long ssid) {
		List<StockStudyRecommend> stockStudyRecommend = em.createQuery("select s FROM StockStudyRecommend s where stockstudy_id = : id", StockStudyRecommend.class)
				.setParameter("id", ssid)
				.getResultList();
		
		return stockStudyRecommend;
	}
	
	public int selectStockStudyRecommendUpCount(long ssid) {
		
		Query countQuery = em.createQuery("select count(s) FROM StockStudyRecommend s WHERE s.stockStudy.id = :id AND s.updown = true");
		
		countQuery.setParameter("id", ssid);
		
		long count = (Long)countQuery.getSingleResult();
		
		int countInt = (int)count;
		
		return countInt;
		
	}
	
	public int selectStockStudyRecommendDownCount(long ssid) {
		
		Query countQuery = em.createQuery("select count(s) FROM StockStudyRecommend s WHERE s.stockStudy.id = :id AND s.updown = false");
		
		countQuery.setParameter("id", ssid);
		
		long count = (Long)countQuery.getSingleResult();
		
		int countInt = (int)count;
		
		return countInt;
		
	}
}
 