package com.roadmmm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.roadmmm.domain.UserSubNickname;
import com.roadmmm.service.UserSubNicknameService;

@Controller
public class UserSubNicknameController {
	
	@Autowired
	UserSubNicknameService userSubNicknameService;
	
	@PostMapping("/admin/usersubnicknameprocess")
	public String adminUserSubNicknamePage(HttpServletRequest request) {
		
		String subNickname = "[" + request.getParameter("subNickname") + "]";
		
		userSubNicknameService.setUserSubNickname(subNickname);
		
		return "redirect:/admin/usersubnicknamepage";
	}
	
	@GetMapping("/admin/usersubnicknamepage")
	public String adminUserSubNicknamePage(Model model) {
		List<UserSubNickname> userSubNicknames = userSubNicknameService.getUserSubNickname();
		
		model.addAttribute("vo", userSubNicknames);
		
		return "userSubNickname";
	}
}
