package com.roadmmm.repository;

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
}
