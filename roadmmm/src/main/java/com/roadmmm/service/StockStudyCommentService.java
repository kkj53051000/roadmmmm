package com.roadmmm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.roadmmm.domain.StockStudyComment;
import com.roadmmm.repository.StockStudyCommentRepository;

@Service
@Transactional
public class StockStudyCommentService {
	@Autowired
	StockStudyCommentRepository stockStudyCommentRepository;
	
	public void saveStockStudyComment(StockStudyComment stockStudyComment) {
		stockStudyCommentRepository.insertStockStudyComment(stockStudyComment);
	}
	
	public List<StockStudyComment> getStockStudyComments(long id) {
		List<StockStudyComment> stockStudyComment =stockStudyCommentRepository.selectStockStudyComments(id);
		
		return stockStudyComment;
	}
	
	public void removeSotckStudyComment(long id) {
		stockStudyCommentRepository.deleteStockStudyComment(id);
	}
	
	public StockStudyComment getStockStudyComment(long sscId) {
		StockStudyComment stockStudyComment =stockStudyCommentRepository.selectStockStudyComment(sscId);
		
		return stockStudyComment;
	}
}
