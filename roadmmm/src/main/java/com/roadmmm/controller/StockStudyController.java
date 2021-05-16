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
import com.roadmmm.domain.StockStudyComment;
import com.roadmmm.domain.StockStudyRecommend;
import com.roadmmm.domain.StockStudyReply;
import com.roadmmm.domain.StockStudyTag;
import com.roadmmm.domain.User;
import com.roadmmm.service.StockStudyCommentService;
import com.roadmmm.service.StockStudyRecommendService;
import com.roadmmm.service.StockStudyReplyService;
import com.roadmmm.service.StockStudyService;
import com.roadmmm.service.UserService;
import com.roadmmm.vo.CommentEnum;
import com.roadmmm.vo.StockStudyCommentVo;
import com.roadmmm.vo.StockStudyContentVo;
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
	private StockStudyReplyService stockStudyReplyService;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/sswrite")
	public String StockStudyWrite() {
		return "stockStudyWrite";
	}
	
	//리스트 관련.
	@GetMapping("/sslist")
	public String StockStudyList(HttpServletRequest request, Model model) {
		
		String sector = request.getParameter("sector");
		String page = request.getParameter("page");
		
		//ALL과 나머지 ENUM들을 분류
		if(sector.equals("ALL")) {
			StockStudyListVo vo = stockStudyService.getStockStudyList(page, sector);
			
			model.addAttribute("vo", vo);
			
			return "stockStudyList";
			
			
		}else {
			StockStudyListVo vo = stockStudyService.getStockStudyListTag(page, sector);
			
			model.addAttribute("vo", vo);
			
			return "stockStudyList";
		}
	}
	//글 관련.
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
	
	@GetMapping("/sscontent")
	public String StockStudyContent(HttpServletRequest request, Model model) {
		
		long ssId = Long.parseLong(request.getParameter("id"));
		//id 컨텐츠
		StockStudy stockStudy = stockStudyService.getStockStudy(ssId);
		
		//추천 비추천 개수
		int upCount = stockStudyRecommendService.getStockStudyRecommendUpCount(ssId);
		int downCount = stockStudyRecommendService.getStockStudyRecommendDwonCount(ssId);
		
		//댓글, 답글
		List<StockStudyCommentVo> stockStudyCommentVoList = new ArrayList<StockStudyCommentVo>();
		
		List<StockStudyComment> stockStudyComment = stockStudyCommentService.getStockStudyComments(ssId);
		
		for(int i =0; i < stockStudyComment.size(); i++) {
			StockStudyCommentVo stockStudyCommentVo = new StockStudyCommentVo(stockStudyComment.get(i).getId(), stockStudyComment.get(i).getContent(), stockStudyComment.get(i).getUser(), CommentEnum.COMMENT);
			stockStudyCommentVoList.add(stockStudyCommentVo);
			
			List<StockStudyReply> stockStudyReply = stockStudyReplyService.getStockStudyReplys(stockStudyComment.get(i).getId());
			
			if(stockStudyReply != null) {
				for(int j = 0; j < stockStudyReply.size(); j++) {
					stockStudyCommentVo = new StockStudyCommentVo(stockStudyReply.get(j).getId(), stockStudyReply.get(j).getContent(), stockStudyReply.get(j).getUser(), CommentEnum.REPLY);
					stockStudyCommentVoList.add(stockStudyCommentVo);
				}
			}
			
		}
		
		StockStudyContentVo vo = new StockStudyContentVo(stockStudy, stockStudyComment, upCount, downCount);
		
		
		
		
		model.addAttribute("vo", vo);
		model.addAttribute("voc", stockStudyCommentVoList);
		
		return "stockStudyContent";
	}
	
	@GetMapping("/sscontentdeleteprocess")
	public String StockStudyContentDelete(HttpServletRequest request, HttpSession session) {
		UserSessionForm userSessionForm = (UserSessionForm)session.getAttribute("user");
		
		long ssId = Long.parseLong(request.getParameter("ssid"));
		
		StockStudy stockStudy = stockStudyService.getStockStudy(ssId);
		
		if(userSessionForm.getUser_id() != stockStudy.getUser().getId()) {
			return "redirect:/sslist";
		}
		
		stockStudyService.removeStockStudy(ssId);
		
		return "redirect:/sslist";
	}
	
	//추천 관련.
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
		
		
		StockStudy stockStudy = stockStudyService.getStockStudy(ssId);
		
		StockStudyRecommend stockStudyRecommend = new StockStudyRecommend(updown, user, stockStudy);
		
		stockStudyRecommendService.saveStockStudyRecommend(stockStudyRecommend);
		
		return "redirect:/sscontent?id=" + ssId;
		
	}
	
	//댓글 관련.
	@PostMapping("/sscommentprocess")
	public String StockStudyCommentProcess(HttpServletRequest request, HttpSession session) {
		UserSessionForm userSessionForm = (UserSessionForm)session.getAttribute("user");
		
		User user = userService.getUser(userSessionForm.getUser_id());
		
		int ssId = Integer.parseInt(request.getParameter("ssid"));
		String content = request.getParameter("content");
		
		StockStudy stockStudy = stockStudyService.getStockStudy(ssId);
		
		StockStudyComment stockStudyComment = new StockStudyComment(content, user, stockStudy);
		
		stockStudyCommentService.saveStockStudyComment(stockStudyComment);
		
		return "redirect:/sscontent?id=" + ssId;
	}
	
	@PostMapping("/sscommentdeleteprocess")
	public String StockStudyCommentDeleteProcess(HttpServletRequest request, HttpSession session) {
		UserSessionForm userSessionForm = (UserSessionForm)session.getAttribute("user");
		
		Long userId = Long.parseLong(request.getParameter("userid"));
		Long sscmId = Long.parseLong(request.getParameter("sscmid"));
		
		//댓글 User와 다를경우.
		if(userSessionForm.getUser_id() != userId) {
			
			return "redirect:/";
		}
		
		stockStudyCommentService.removeSotckStudyComment(sscmId);
		
		return "redirect:/";
	}
	
	//답글 관련.
	@PostMapping("ssreplyprocess")
	public String StockStudyReplyProcess(HttpServletRequest request, HttpSession session) {
		UserSessionForm userSessionForm = (UserSessionForm)session.getAttribute("user");
		
		User user = userService.getUser(userSessionForm.getUser_id());
		
		String content = request.getParameter("content");
		
		long ssId = Long.parseLong(request.getParameter("ssid"));
		long sscId = Long.parseLong(request.getParameter("sscid"));
		
		StockStudyComment stockStudyComment = stockStudyCommentService.getStockStudyComment(sscId);
		
		StockStudyReply stockStudyReply = new StockStudyReply(content, stockStudyComment, user);
		
		stockStudyReplyService.saveStockStudyReply(stockStudyReply);
		
		return "redirect:/sscontent?id=" + ssId;
		
	}
}
