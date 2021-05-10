package com.roadmmm.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.roadmmm.domain.StockStudy;
import com.roadmmm.domain.StockStudyTag;
import com.roadmmm.repository.StockStudyRepository;

@Service
@Transactional
public class StockStudyService {
	@Autowired
	StockStudyRepository stockStudyRepository;
	
	public void saveStockStudy(StockStudy stockStudy) {
		
		stockStudyRepository.insertStockStudy(stockStudy);
		
	}
	
	public List<StockStudy> findStockStudys(){
		
		
		List<StockStudy> stockStudys = stockStudyRepository.selectStockStduys();
		
		return stockStudys;
	}
	
	public List<StockStudy> findStockStudys(StockStudyTag tag){
		
		
		List<StockStudy> stockStudys = stockStudyRepository.selectStockStduysAn(tag);
		
		return stockStudys;
	}
}
