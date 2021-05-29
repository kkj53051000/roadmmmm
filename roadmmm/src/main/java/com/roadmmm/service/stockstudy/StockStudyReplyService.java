package com.roadmmm.service.stockstudy;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.roadmmm.domain.stockstudy.StockStudyReply;
import com.roadmmm.repository.stockstudy.StockStudyReplyRepository;

@Service
@Transactional
public class StockStudyReplyService {
	@Autowired
	StockStudyReplyRepository stockStudyReplyRepository;
	
	public void saveStockStudyReply(StockStudyReply stockStudyReply) {
		stockStudyReplyRepository.insertStockStudyReply(stockStudyReply);
	}
	
	public List<StockStudyReply> getStockStudyReplys(long ssrId){
		List<StockStudyReply> stockStudyReply = stockStudyReplyRepository.selectStockStudyReplys(ssrId);
		
		return stockStudyReply;
	}
}
