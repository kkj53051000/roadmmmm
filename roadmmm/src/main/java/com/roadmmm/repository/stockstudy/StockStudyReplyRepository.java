package com.roadmmm.repository.stockstudy;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.roadmmm.domain.stockstudy.StockStudyReply;

@Repository
public class StockStudyReplyRepository {
	@PersistenceContext
	EntityManager em;
	
	public void insertStockStudyReply(StockStudyReply stockStudyReply) {
		em.persist(stockStudyReply);
	}
	
	public List<StockStudyReply> selectStockStudyReplys(long ssrId){
		List<StockStudyReply> stockStudyReplys = em.createQuery("select s FROM StockStudyReply s WHERE s.stockStudyComment.id = :id", StockStudyReply.class)
				.setParameter("id", ssrId)
				.getResultList();
		
		return stockStudyReplys;
	}
}
