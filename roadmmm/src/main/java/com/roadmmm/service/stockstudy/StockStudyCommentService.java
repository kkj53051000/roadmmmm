package com.roadmmm.service.stockstudy;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.roadmmm.domain.stockstudy.StockStudyComment;
import com.roadmmm.repository.stockstudy.StockStudyCommentRepository;

@Service
@Transactional
public class StockStudyCommentService {
	@Autowired
	StockStudyCommentRepository stockStudyCommentRepository;
	
	public void saveStockStudyComment(StockStudyComment stockStudyComment) {
		stockStudyCommentRepository.insertStockStudyComment(stockStudyComment);
	}
	
	public List<StockStudyComment> getStockStudyComments(long ssId) {
		List<StockStudyComment> stockStudyComment =stockStudyCommentRepository.selectStockStudyComments(ssId);
		
		return stockStudyComment;
	}
	
	public void removeSotckStudyComment(long sscId) {
		stockStudyCommentRepository.deleteStockStudyComment(sscId);
	}
	
	public StockStudyComment getStockStudyComment(long sscId) {
		StockStudyComment stockStudyComment =stockStudyCommentRepository.selectStockStudyComment(sscId);
		
		return stockStudyComment;
	}
}
