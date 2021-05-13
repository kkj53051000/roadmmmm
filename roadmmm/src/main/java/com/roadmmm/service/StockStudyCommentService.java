package com.roadmmm.service;

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
}
