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
import com.roadmmm.domain.StockStudyComment;
import com.roadmmm.domain.StockStudyRecommend;
import com.roadmmm.domain.StockStudyTag;
import com.roadmmm.domain.User;
import com.roadmmm.service.StockStudyCommentService;
import com.roadmmm.service.StockStudyRecommendService;
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
	private StockStudyRecommendService stockStudyRecommendService;
	
	@Autowired
	private StockStudyCommentService stockStudyCommentService;
	
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
		for(int i = 0; i <= 101; i++) {
			User user = userService.getUser(userSession.getUser_id());
			
			Date now = new Date();
			
			StockStudy stockStudy = new StockStudy(stockStudyForm.getTitle(), stockStudyForm.getContent(), now, StockStudyTag.valueOf(stockStudyForm.getTag()), user);
			
			stockStudyService.saveStockStudy(stockStudy);
		}
		
		
		return "redirect:/sslist?sector=ALL";
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
	
	@GetMapping("/sscontent")
	public String StockStudyContent(HttpServletRequest request, Model model) {
		
		long id = Long.parseLong(request.getParameter("id"));
		//id 컨텐츠
		StockStudy stockStudy = stockStudyService.findStockStudy(id);
		
		//추천 비추천 개수
		int upCount = stockStudyRecommendService.getStockStudyRecommendUpCount(id);
		
		model.addAttribute("vo", stockStudy);
		model.addAttribute("up", upCount);
		
		return "stockStudyContent";
	}
	
	@GetMapping("/ssrecommendprocess")
	public String StockStudyRecommendProcess(HttpServletRequest request, HttpSession session) {
		UserSessionForm userSessionForm = (UserSessionForm)session.getAttribute("user");
		
		User user = userService.getUser(userSessionForm.getUser_id());
		
		boolean updown = Boolean.parseBoolean(request.getParameter("updown"));
		long ssId = Long.parseLong(request.getParameter("id"));
		
		//추천 이미 눌렀는지 확인
		boolean check = stockStudyRecommendService.checkStockStudyRecommend(ssId, user.getId());
		
		if(check == true) {
			return "redirect:/";
		}
		
		
		StockStudy stockStudy = stockStudyService.findStockStudy(ssId);
		
		StockStudyRecommend stockStudyRecommend = new StockStudyRecommend(updown, user, stockStudy);
		
		stockStudyRecommendService.saveStockStudyRecommend(stockStudyRecommend);
		
		return "redirect:/sscontent?id=" + ssId;
		
	}
	
	@PostMapping("/sscommentprocess")
	public String StockStudyCommentProcess(HttpServletRequest request, HttpSession session) {
		UserSessionForm userSessionForm = (UserSessionForm)session.getAttribute("user");
		
		User user = userService.getUser(userSessionForm.getUser_id());
		
		int ssid = Integer.parseInt(request.getParameter("ssid"));
		String content = request.getParameter("content");
		
		StockStudy stockStudy = stockStudyService.findStockStudy(ssid);
		
		StockStudyComment stockStudyComment = new StockStudyComment(content, user, stockStudy);
		
		stockStudyCommentService.saveStockStudyComment(stockStudyComment);
		
		return "";
	}
}
