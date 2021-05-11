package com.roadmmm.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
import com.roadmmm.repository.StockStudyRepository;
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
		for(int i = 0; i <= 10; i++) {
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
		
		if(sector.equals("all")) {
			
			int currentPage = 0;
			int pageOffSet = 0;
			if(request.getParameter("id") != null) {
				currentPage = Integer.parseInt(request.getParameter("id"));
				
				pageOffSet = ((currentPage - 1) * 10) + 1;
			}
			
			List<StockStudy> stockStudys = stockStudyService.findStockStudys(pageOffSet);
			
			int count = stockStudyService.findStockStudyCount();
			
			
			
			int pageStartNum = (int)(count / 10) - (count % 10) + 1;
			int pageLastNum = (int)(count / 10) + 1;

			List<Integer> pageList = new ArrayList<>();
			
			//페이지 List
			if(pageLastNum < 11) {	
				for(int i = 1; i <= pageLastNum; i++) {
					pageList.add(i);
					
					System.out.println("10 이하i : " + i);
				}
				
			}else {
				for(int i = pageStartNum; i <= pageLastNum; i++) {
					pageList.add(pageStartNum);
					
					System.out.println("i : " + pageStartNum);
					
					pageStartNum++;
				}
			}
			
			StockStudyListVo vo = new StockStudyListVo(stockStudys, pageList);
			
			model.addAttribute("vo", vo);
			
			return "stockStudyList";
		}else {
			StockStudyTag tag = StockStudyTag.valueOf(sector);
			
			List<StockStudy> stockStudys = stockStudyService.findStockStudys(tag);
			
			model.addAttribute("stockStudys", stockStudys);
			
			return "stockStudyList";
		}
		
		
	}
}
