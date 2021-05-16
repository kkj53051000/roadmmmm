package com.roadmmm.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.roadmmm.domain.StockStudyComment;

@Repository
public class StockStudyCommentRepository {
	@PersistenceContext
	EntityManager em;
	
	public void insertStockStudyComment(StockStudyComment stockStudyComment) {
		em.persist(stockStudyComment);
	}
	
	public List<StockStudyComment> selectStockStudyComments(long id) {
		List<StockStudyComment> stockStudyComments = em.createQuery("select s FROM StockStudyComment s join fetch s.user WHERE s.stockStudy.id = :id", StockStudyComment.class)
				.setParameter("id", id)
				.getResultList();
		
		return stockStudyComments;
	}
	
	public void deleteStockStudyComment(long id) {
		StockStudyComment stockStudyComment = em.find(StockStudyComment.class, id);
		
		em.remove(stockStudyComment);
	}
	
	public StockStudyComment selectStockStudyComment(long sscId) {
		StockStudyComment stockStudyComment = em.find(StockStudyComment.class, sscId);
		
		return stockStudyComment;
	}
}
