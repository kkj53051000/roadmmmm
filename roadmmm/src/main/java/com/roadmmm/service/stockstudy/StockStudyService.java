package com.roadmmm.service.stockstudy;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.roadmmm.domain.stockstudy.StockStudy;
import com.roadmmm.domain.stockstudy.StockStudyTag;
import com.roadmmm.repository.stockstudy.StockStudyRepository;
import com.roadmmm.vo.StockStudyListVo;

@Service
@Transactional
public class StockStudyService {
	@Autowired
	StockStudyRepository stockStudyRepository;
	
	public void saveStockStudy(StockStudy stockStudy) {
		
		stockStudyRepository.insertStockStudy(stockStudy);
		
	}
	
	
	
	public StockStudyListVo getStockStudyList(String page, String sector) {
		int currentPage = 0;
		int startPage = 0;
		
		boolean beforePage = false;
		boolean afterPage = false;
		
		int beforePageNum = 0;
		int afterPageNum = 0;
		
		if(page != null) {
			currentPage = Integer.parseInt(page);
			
			startPage = ((currentPage - 1) * 10);
		}
		
		 List<StockStudy> stockStudys = stockStudyRepository.selectStockStduys(startPage);

		
		int count = stockStudyRepository.selectStockStudyCount();
	
		int pageLastNum = (int)(count / 10) + 1;

		List<Integer> pageList = new ArrayList<>();
		
		//페이징, 10페이지 이하의 조건.
		if(count < 101) {
			beforePage = false;
			if(count > 100) {
				afterPage = true;
			}
			afterPageNum = (currentPage + 10) - (currentPage % 10) + 1;
			
			for(int i = 1; i <= pageLastNum; i++) {
				pageList.add(i);
			}
			
		}else { //페이징, 10페이지 초과의 조건.
			
			//이전,이후 페이지 여부
			if(currentPage >= 11) {
				beforePage = true;
			}
			if((currentPage - 1) / 10 < pageLastNum / 10) { //다음페이지 X
				afterPage = true;
			}else {
				afterPage = false;
			}
			
			//10으로 나눠지는 수들의 문제때문에 -- 추가.
			if(currentPage % 10 == 0) {
				currentPage--;
			}
			
			beforePageNum = (currentPage - 10) - (currentPage % 10) + 1;
			afterPageNum = (currentPage + 10) - (currentPage % 10) + 1;
			
			int lastPage = currentPage - (currentPage %10) + 10;
			
			if(afterPage == false) {
				lastPage = pageLastNum;
			}
			
			for(int i = currentPage - (currentPage %10) + 1; i <= lastPage; i++) {
				pageList.add(i);
			}
			
			
			
		}
		
		StockStudyListVo vo = new StockStudyListVo(stockStudys, pageList, beforePage, afterPage, beforePageNum, afterPageNum, StockStudyTag.ALL);
		
		
		return vo;
	}
	
	public StockStudyListVo getStockStudyListTag(String page, String sector) {
		int currentPage = 0;
		int startPage = 0;
		
		boolean beforePage = false;
		boolean afterPage = false;
		
		int beforePageNum = 0;
		int afterPageNum = 0;
		
		if(page != null) {
			currentPage = Integer.parseInt(page);
			
			startPage = ((currentPage - 1) * 10);
		}
		
		StockStudyTag tag = StockStudyTag.valueOf(sector);
		
		List<StockStudy> stockStudys = stockStudyRepository.selectStockStduysAn(tag, startPage);
		
		int count = stockStudyRepository.selectStockStudtCountTag(tag);
		
		int pageLastNum = (int)(count / 10) + 1;
		

		List<Integer> pageList = new ArrayList<>();
		
		//페이징, 10페이지 이하의 조건.
		if(count < 101) {
			beforePage = false;
			if(count > 100) {
				afterPage = true;
			}
			afterPageNum = (currentPage + 10) - (currentPage % 10) + 1;
			
			pageLastNum = 10;
			
			for(int i = 1; i <= pageLastNum; i++) {
				pageList.add(i);
			}
			
		}else { //페이징, 10페이지 초과의 조건.
			
			//이전,이후 페이지 여부
			if(currentPage >= 11) {
				beforePage = true;
			}
			if((currentPage - 1) / 10 < pageLastNum / 10) {
				afterPage = true;
			}else {
				afterPage = false;
			}
			
			if(currentPage % 10 == 0) {
				currentPage--;
			}
			
			beforePageNum = (currentPage - 10) - (currentPage % 10) + 1;
			afterPageNum = (currentPage + 10) - (currentPage % 10) + 1;
			
			int lastPage = currentPage - (currentPage %10) + 10;
			
			if(afterPage == false) {
				lastPage = pageLastNum;
			}
			
			for(int i = currentPage - (currentPage %10) + 1; i <= lastPage; i++) {
				pageList.add(i);
			}
			
		}
		
		StockStudyListVo vo = new StockStudyListVo(stockStudys, pageList, beforePage, afterPage, beforePageNum, afterPageNum, tag);
		
		return vo;
	}
	
	public StockStudyListVo getStockStudyBestList(String page, int start, int standard) {
		
		
		int currentPage = 0;
		int startPage = 0;
		
		boolean beforePage = false;
		boolean afterPage = false;
		
		int beforePageNum = 0;
		int afterPageNum = 0;
		
		if(page != null) {
			currentPage = Integer.parseInt(page);
			
			startPage = ((currentPage - 1) * 10);
		}
		
		List<StockStudy> stockStudys = stockStudyRepository.selectStockStduyBests(startPage, standard);
		
		int count = stockStudyRepository.selectStockStudyBestCount();
		
		int pageLastNum = (int)(count / 10) + 1;

		List<Integer> pageList = new ArrayList<>();
		
		//페이징, 10페이지 이하의 조건.
		if(count < 101) {
			beforePage = false;
			if(count > 100) {
				afterPage = true;
			}
			afterPageNum = (currentPage + 10) - (currentPage % 10) + 1;
			
			for(int i = 1; i <= pageLastNum; i++) {
				pageList.add(i);
			}
			
		}else { //페이징, 10페이지 초과의 조건.
			
			//이전,이후 페이지 여부
			if(currentPage >= 11) {
				beforePage = true;
			}
			if((currentPage - 1) / 10 < pageLastNum / 10) {
				afterPage = true;
			}else {
				afterPage = false;
			}
			
			if(currentPage % 10 == 0) {
				currentPage--;
			}
			
			beforePageNum = (currentPage - 10) - (currentPage % 10) + 1;
			afterPageNum = (currentPage + 10) - (currentPage % 10) + 1;
			
			int lastPage = currentPage - (currentPage %10) + 10;
			
			if(afterPage == false) {
				lastPage = pageLastNum;
			}
			
			for(int i = currentPage - (currentPage %10) + 1; i <= lastPage; i++) {
				pageList.add(i);
			}
			
		}
		
		
		StockStudyListVo vo = new StockStudyListVo(stockStudys, pageList, beforePage, afterPage, beforePageNum, afterPageNum);
		
		return vo;
	}
	
	
	public StockStudy getStockStudy(long ssId) {
		return stockStudyRepository.selectStockStudy(ssId);
	}
	
	public void removeStockStudy(long ssId) {
		stockStudyRepository.deleteStockStudy(ssId);
	}
	
	public void addStockStudyUpCount(long ssId) {
		stockStudyRepository.alertStockStudyUpCount(ssId);
	}
	
	public void addStockStudyDownCount(long ssId) {
		stockStudyRepository.alertStockStudyDownCount(ssId);
	}
	
	public void setStockStudyBestCheck(long ssId) {
		stockStudyRepository.alertStockStudyBestCheck(ssId);
	}
}
