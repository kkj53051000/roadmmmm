package com.roadmmm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.roadmmm.domain.PopularLive;
import com.roadmmm.service.PopularService;
import com.roadmmm.vo.PopularInfoForm;

@Controller
public class PopularController {
	
	@Autowired
	PopularService popularService;
	
	@GetMapping("/pplist")
	public String popularListPage(Model model) {
		
		List<PopularLive> popularLives = popularService.getPopularLives();
		
		
		
		//해당 게시판의 제목, 아이디, 추천수, 날짜를 가져와야함.
		List<PopularInfoForm> popularInfoForms = popularService.getPopularInfo(popularLives);
		
		
		
		model.addAttribute("vo", popularInfoForms);
		
		return "popularList";
	}
	
	
}