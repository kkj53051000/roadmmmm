package com.roadmmm.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.roadmmm.domain.GuideLine;
import com.roadmmm.domain.stockstudy.StockStudyTag;
@Repository
public class GuideLineRepository {
	@PersistenceContext
	EntityManager em;
	
	public void insertGuideLine(GuideLine guideLine) {
		em.persist(guideLine);
	}
	
	public List<GuideLine> selectGuideLineList(StockStudyTag tag, int start){
		TypedQuery<GuideLine> query = em.createQuery("select g FROM GuideLine g WHERE g.tag = :tag", GuideLine.class);
		
		query.setParameter("tag", tag);
		query.setFirstResult(start);
		query.setMaxResults(9);
		
		List<GuideLine> guideLines = query.getResultList();
		
		return guideLines;
		
	}
	
	public int selectGuideLineListCount(StockStudyTag tag) {
		Query countQuery = em.createQuery("select count(g) FROM GuideLine g WHERE g.tag = :tag");
		
		countQuery.setParameter("tag", tag);
		
		long count = (Long)countQuery.getSingleResult();
		
		int countInt = (int)count;
		
		return countInt;
	}
}
