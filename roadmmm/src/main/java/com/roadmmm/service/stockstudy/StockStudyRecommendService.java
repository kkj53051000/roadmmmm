package com.roadmmm.service.stockstudy;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.roadmmm.domain.stockstudy.StockStudyRecommend;
import com.roadmmm.repository.stockstudy.StockStudyRecommendRepository;

@Service
@Transactional
public class StockStudyRecommendService {
	@Autowired
	StockStudyRecommendRepository stockStudyRecommendRepository;
	
	public void saveStockStudyRecommend(StockStudyRecommend stockStudyRecommend) {
		stockStudyRecommendRepository.insertStockStudyRecommend(stockStudyRecommend);
	}
	
	public boolean checkStockStudyRecommend(long ssid, long user_id) {
		List<StockStudyRecommend> stockStudyRecommend = stockStudyRecommendRepository.selectStockStudyRecommendList(ssid);
		
		for(int i = 0; i < stockStudyRecommend.size(); i++) {
			if(stockStudyRecommend.get(i).getUser().getId() == user_id) {
				return true;
			}
		}
		
		return false;
	}
	
	public int getStockStudyRecommendUpCount(long ssId) {
		
		return stockStudyRecommendRepository.selectStockStudyRecommendUpCount(ssId);
		
	}
	
	public int getStockStudyRecommendDwonCount(long ssId) {
		
		return stockStudyRecommendRepository.selectStockStudyRecommendDownCount(ssId);
		
	}
	
	
}
