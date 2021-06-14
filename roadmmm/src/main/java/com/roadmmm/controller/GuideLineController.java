package com.roadmmm.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.roadmmm.domain.GuideLine;
import com.roadmmm.domain.User;
import com.roadmmm.domain.stockstudy.StockStudyTag;
import com.roadmmm.service.GuideLineService;
import com.roadmmm.service.UserService;
import com.roadmmm.vo.GuideLineListForm;
import com.roadmmm.vo.GuideLineListVo;
import com.roadmmm.vo.GuideLineWriteForm;
import com.roadmmm.vo.UserSessionForm;

@MultipartConfig(
		fileSizeThreshold=1024*1024,
		maxFileSize=1024*1024*20,
		maxRequestSize=1024*1024*30
)

@Controller
public class GuideLineController {
	@Autowired
	GuideLineService guideLineService;
	
	@Autowired
	UserService userService;
	
	@GetMapping("/glwrite")
	public String GuideLineWritePage() {
		return "guideLineWrite";
	}
	
	@PostMapping("/glprocess")
	public String GuideLineWriteProcess(GuideLineWriteForm guideLineWriteForm, HttpServletRequest request, HttpSession session) throws IOException, ServletException {
		//User
		UserSessionForm userSession = (UserSessionForm)session.getAttribute("user");
		User user = userService.getUser(userSession.getUser_id());
		//Date
		Date now = new Date();
		//tag
		StockStudyTag tag = StockStudyTag.valueOf(guideLineWriteForm.getSector());
		
		//타이틀 이미지 처리 부분
		Part filePart = request.getPart("titleImg");
		String fileName = filePart.getSubmittedFileName();
		
		if(fileName.equals("")) {
			// 사진을 업로드 안했을 경우
		}
		
		String realPath = request.getServletContext().getRealPath("");
		
		String temp = "";
		
		for(int i=0; i < realPath.indexOf("webapp"); i++) {
			temp += realPath.charAt(i);
		}
		
		String publicRealPath = temp + "resources" + File.separator + "static" + File.separator + "img" + File.separator;
		
		String filePath = publicRealPath + fileName;
		
		String clientPath = File.separator + "static" + File.separator + "img" + File.separator + fileName;
		
		InputStream fis = filePart.getInputStream();
		FileOutputStream fos = new FileOutputStream(filePath);
		
		byte[] buffer = new byte[1024];
		
		int size = 0;
		while((size = fis.read(buffer)) != -1) {
			fos.write(buffer, 0, size);
		}
		
		GuideLine guideLine = new GuideLine(guideLineWriteForm.getTitle(), clientPath, guideLineWriteForm.getContent(), now, tag, user);
		
		guideLineService.saveGuideLine(guideLine);
		
		return "redirect:/gllist";
	}
	
	@GetMapping("/gllist")
	public String GuideLineListPage(HttpServletRequest request, Model model) {
		
		String sector = request.getParameter("sector");
		String page = request.getParameter("page");
		
		GuideLineListVo guideLineListVo = guideLineService.getGuideLineList(sector, page);
		
		model.addAttribute("vo", guideLineListVo);
		
		return "guideLineList";
	}
}
