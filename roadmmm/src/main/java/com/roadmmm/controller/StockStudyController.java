package com.roadmmm.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.roadmmm.domain.StockStudy;
import com.roadmmm.domain.StockStudyTag;
import com.roadmmm.domain.User;
import com.roadmmm.service.StockStudyService;
import com.roadmmm.service.UserService;
import com.roadmmm.vo.StockStudyForm;
import com.roadmmm.vo.StockStudyListVo;
import com.roadmmm.vo.UserSessionForm;

@Controller
public class StockStudyController {
	
	@Autowired
	private StockStudyService stockStudyService;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/sswrite")
	public String StockStudyWrite() {
		return "stockStudyWrite";
	}
	
	@PostMapping("/stockstudyprocess")
	public String StockStudyProcess(HttpServletRequest request, HttpSession session, StockStudyForm stockStudyForm){
		
		UserSessionForm userSession = (UserSessionForm)session.getAttribute("user");
		
		if(userSession == null) {
			return "redirect:/";
		}
		for(int i = 0; i <= 10000; i++) {
			User user = userService.getUser(userSession.getUser_id());
			
			Date now = new Date();
			
			StockStudy stockStudy = new StockStudy(stockStudyForm.getTitle(), stockStudyForm.getContent(), now, StockStudyTag.valueOf(stockStudyForm.getTag()), user);
			
			stockStudyService.saveStockStudy(stockStudy);
		}
		
		
		return "redirect:/sslist?sector=all";
	}
	
	@GetMapping("/sslist")
	public String StockStudyList(HttpServletRequest request, Model model) {
		
		String sector = request.getParameter("sector");
		String page = request.getParameter("page");
		
		//ALL과 나머지 ENUM들을 분류
		if(sector.equals("ALL")) {
			StockStudyListVo vo = stockStudyService.findStockStudyList(page, sector);
			
			model.addAttribute("vo", vo);
			
			return "stockStudyList";
			
			
		}else {
			StockStudyListVo vo = stockStudyService.findStockStudyListTag(page, sector);
			
			model.addAttribute("vo", vo);
			
			return "stockStudyList";
		}
	}
}
