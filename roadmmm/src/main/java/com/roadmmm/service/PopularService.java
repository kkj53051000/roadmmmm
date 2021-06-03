package com.roadmmm.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.roadmmm.domain.PopularLive;
import com.roadmmm.domain.stockstudy.StockStudy;
import com.roadmmm.repository.PopularRepository;
import com.roadmmm.vo.PopularInfoForm;

@Service
@Transactional
public class PopularService {
	@Autowired
	private PopularRepository popularRepository;
	
	public void savePopularLive(PopularLive popularLive) {
		popularRepository.insertPopularLive(popularLive);
	}
	
	public List<PopularLive> getPopularLives(){
		List<PopularLive> popularLives = popularRepository.selectPopularLives();
		
		return popularLives;
	}
	
	public List<PopularInfoForm> getPopularLiveInfo(List<PopularLive> popularLives){
		
		List<PopularInfoForm> popularInfoForms = new ArrayList<PopularInfoForm>();
		
		for(int i = 0; i < popularLives.size(); i++) {
			
			if(popularLives.get(i).getBoardName().equals("StockStudy")) {
				
				StockStudy stockSutdy = popularRepository.selectPopularLiveListInfo(popularLives.get(i));
				
				PopularInfoForm popularInfoForm = new PopularInfoForm(popularLives.get(i).getBoardId(), popularLives.get(i).getBoardName(), stockSutdy.getTitle(), stockSutdy.getDate(), stockSutdy.getUser().getNickname());
				
				popularInfoForms.add(popularInfoForm);
			}
		}
		
		return popularInfoForms;
	}
	
	public List<PopularLive> getPopularDays(String dayStart, String dayEnd){
		List<PopularLive> popularDays = popularRepository.selectPopularDays(dayStart, dayEnd);
		
		return popularDays;
	}
	
}
