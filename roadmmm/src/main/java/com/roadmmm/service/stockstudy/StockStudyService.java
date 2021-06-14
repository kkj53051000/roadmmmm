package com.roadmmm.service.stockstudy;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.roadmmm.domain.stockstudy.StockStudy;
import com.roadmmm.domain.stockstudy.StockStudyTag;
import com.roadmmm.repository.stockstudy.StockStudyRepository;
import com.roadmmm.util.PagingUtil;
import com.roadmmm.vo.PagingForm;
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
		int count = stockStudyRepository.selectStockStudyCount();
		
		PagingForm pagingForm = PagingUtil.pagingUtil(page, count);
		
		List<StockStudy> stockStudys = stockStudyRepository.selectStockStduys(pagingForm.getStartPage());
		
		StockStudyListVo vo = new StockStudyListVo(stockStudys, pagingForm.getPageList(), pagingForm.isBeforePage(), pagingForm.isAfterPage(), pagingForm.getBeforePageNum(), pagingForm.getAfterPageNum(), StockStudyTag.ALL);
		
		
		return vo;
	}
	
	public StockStudyListVo getStockStudyListTag(String page, String sector) {
		StockStudyTag tag = StockStudyTag.valueOf(sector);
		int count = stockStudyRepository.selectStockStudtCountTag(tag);
		
		PagingForm pagingForm = PagingUtil.pagingUtil(page, count);
		
		List<StockStudy> stockStudys = stockStudyRepository.selectStockStduysAn(tag, pagingForm.getStartPage());
		
		StockStudyListVo vo = new StockStudyListVo(stockStudys, pagingForm.getPageList(), pagingForm.isBeforePage(), pagingForm.isAfterPage(), pagingForm.getBeforePageNum(), pagingForm.getAfterPageNum(), tag);
		
		return vo;
	}
	
	public StockStudyListVo getStockStudyBestList(String page) {
		
		int count = stockStudyRepository.selectStockStudyBestCount();
		
		PagingForm pagingForm = PagingUtil.pagingUtil(page, count);
				
		List<StockStudy> stockStudys = stockStudyRepository.selectStockStduyBests(pagingForm.getStartPage());
		
		StockStudyListVo vo = new StockStudyListVo(stockStudys, pagingForm.getPageList(), pagingForm.isBeforePage(), pagingForm.isAfterPage(), pagingForm.getBeforePageNum(), pagingForm.getAfterPageNum());
		
		return vo;
	}
	
	
	public StockStudyListVo getStockStudyBestListTag(String page, String sector) {
		
		int count = stockStudyRepository.selectStockStudyBestCount();
		
		PagingForm paginForm = PagingUtil.pagingUtil(page, count);
		
		StockStudyTag tag = StockStudyTag.valueOf(sector);
		
		List<StockStudy> stockStudys = stockStudyRepository.selectStockStudyBestsAn(paginForm.getStartPage(), tag);
		
		
		StockStudyListVo vo = new StockStudyListVo(stockStudys, paginForm.getPageList(), paginForm.isBeforePage(), paginForm.isAfterPage(), paginForm.getBeforePageNum(), paginForm.getAfterPageNum());
		
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
