package com.roadmmm.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.Logger;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.roadmmm.domain.PopularLive;
import com.roadmmm.domain.stockstudy.StockStudy;
import com.roadmmm.domain.stockstudy.StockStudyRecommend;
import com.roadmmm.repository.PopularRepository;
import com.roadmmm.repository.stockstudy.StockStudyRepository;
import com.roadmmm.util.PagingUtil;
import com.roadmmm.vo.PagingForm;
import com.roadmmm.vo.PopularInfoForm;
import com.roadmmm.vo.PopularListForm;

import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
public class PopularService {
	@Autowired
	private PopularRepository popularRepository;
	
	@Autowired
	private StockStudyRepository stockStudyRepository;
	
	public void savePopularLive(PopularLive popularLive) {
		popularRepository.insertPopularLive(popularLive);
		
/*
 * useful info
 * log kinds 
 * useful feature
 * perf
 * */
		log.info("SDFSDFSDF {}      {}", "SDFSDF", "202020");
		log.debug("popurlarServiceListCount = {}", 5);
		log.error("sdfsdfsd");
		log.warn("SDFSADFDF");
		
		System.out.println("SDFSDFDF");
		System.out.println("SDFSDFDF");
		System.out.println("SDFSDFDF");
		
		int a = 3;
	}
	
	
	// PageingUtilClass
//	public calculate(String page, int count) {
//		action1();
//		
//		
//		
//		myAction();
//		
//		
//		
//		action2();
//	}
	
	
	//인기게시글(라이브) 정보폼, 페이징
	public PopularListForm getPopularLiveInfo(String page){
		//PagningUtil.calcuate(page, count);
		
		int count = popularRepository.selectPopularLiveCount();
		
		PagingForm pagingFrom = PagingUtil.pagingUtil(page, count);
		
		List<PopularLive> popularLives = popularRepository.selectPopularLives(pagingFrom.getStartPage());
		
		//Form에 담는 부분
		List<PopularInfoForm> popularInfoForms = new ArrayList<PopularInfoForm>();
		
		for(int i = 0; i < popularLives.size(); i++) {
			
			if(popularLives.get(i).getBoardName().equals("StockStudy")) {
				
				StockStudy stockSutdy = stockStudyRepository.selectPopularListStockStudy(popularLives.get(i));
				
				PopularInfoForm popularInfoForm = new PopularInfoForm(popularLives.get(i).getBoardId(), popularLives.get(i).getBoardName(), stockSutdy.getTitle(), stockSutdy.getDate(), stockSutdy.getUser());
				
				popularInfoForms.add(popularInfoForm);
			}
		}
		
		PopularListForm popularListForm = new PopularListForm(popularInfoForms, pagingFrom.getPageList(), pagingFrom.isBeforePage(), pagingFrom.isAfterPage(), pagingFrom.getBeforePageNum(), pagingFrom.getAfterPageNum());
		
		return popularListForm;
	}
	
	public PopularListForm getPopularDays(Date dayStart, Date dayEnd, String page){
		
		int count = popularRepository.selectPopularDayCount(dayStart, dayEnd);
		
		PagingForm pagingFrom = PagingUtil.pagingUtil(page, count);
		
		List<PopularLive> popularDays = popularRepository.selectPopularDays(dayStart, dayEnd, pagingFrom.getStartPage());
		//Form에 담는 부분
		List<PopularInfoForm> popularInfoForms = new ArrayList<PopularInfoForm>();
		
		for(int i = 0; i < popularDays.size(); i++) {
			if(popularDays.get(i).getBoardName().equals("StockStudy")) {
				
				
				StockStudy stockSutdy = stockStudyRepository.selectPopularListStockStudy(popularDays.get(i));
				
				PopularInfoForm popularInfoForm = new PopularInfoForm(popularDays.get(i).getBoardId(), popularDays.get(i).getBoardName(), stockSutdy.getTitle(), stockSutdy.getDate(), stockSutdy.getUser());
				
				popularInfoForms.add(popularInfoForm);
			}
		}
		
		PopularListForm popularListForm = new PopularListForm(popularInfoForms, pagingFrom.getPageList(), pagingFrom.isBeforePage(), pagingFrom.isAfterPage(), pagingFrom.getBeforePageNum(), pagingFrom.getAfterPageNum());
		
		
		return popularListForm;
	}
	
	public List<PopularInfoForm> getPopularMonths(Date monthStart, Date monthEnd){
		List<PopularLive> popularMonths = popularRepository.selectPopularMonths(monthStart, monthEnd);
		
		List<PopularInfoForm> popularInfoForms = new ArrayList<PopularInfoForm>();
		
		for(int i = 0; i < popularMonths.size(); i++) {
			if(popularMonths.get(i).getBoardName().equals("StockStudy")) {
				
				
				StockStudy stockSutdy = stockStudyRepository.selectPopularListStockStudy(popularMonths.get(i));
				
				PopularInfoForm popularInfoForm = new PopularInfoForm(popularMonths.get(i).getBoardId(), popularMonths.get(i).getBoardName(), stockSutdy.getTitle(), stockSutdy.getDate(), stockSutdy.getUser());
				
				popularInfoForms.add(popularInfoForm);
			}
		}
		
		return popularInfoForms;
	}
	
}
