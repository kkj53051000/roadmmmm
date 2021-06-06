package com.roadmmm.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
	public String popularListPage(HttpServletRequest request, Model model) {
		
		String sector = request.getParameter("sector");
		String dayStartStr = request.getParameter("day") + " 00:00:00";
		String dayEndStr = request.getParameter("day") + " 23:59:59";
		String day = request.getParameter("day");
		
		List<PopularLive> popularLives = popularService.getPopularLives();
		
		List<PopularInfoForm> popularInfoForms = new ArrayList<>();
		
		
		//해당 게시판의 제목, 아이디, 추천수, 날짜를 가져와야함. .
		if(sector.equals("LIVE")) {
			popularInfoForms = popularService.getPopularLiveInfo(popularLives);
		}else if(sector.equals("DAY")) {			
			try {
				SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
				SimpleDateFormat fm_start = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
				
				Date dayDate = fm.parse(dayStartStr); //yyyy-MM-dd
				Date dayStart = fm_start.parse(dayStartStr); //yyyy-MM-dd 00:00:00
				Date dayEnd = fm_start.parse(dayEndStr); //yyyy-MM-dd 23:59:59
				
				System.out.println("dayStart : " + dayStart);
				System.out.println("dayEnd : " + dayEnd);
	
				//List<PopularLive> popularDays = popularService.getPopularDays(dayStartStr, dayEndStr);
				
				
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		model.addAttribute("vo", popularInfoForms);
		
		return "popularList";
	}
	
	
}