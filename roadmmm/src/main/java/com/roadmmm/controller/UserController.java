package com.roadmmm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.roadmmm.service.UserService;
import com.roadmmm.vo.JoinForm;

@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/")
	public String mainPage() {
		return "main";
	}
	
	@GetMapping("/join")
	public String joinPage() {
		return "join";
	}
	
	@PostMapping("/joinprocess")
	public String join(JoinForm joinForm) {
		
		userService.saveUser(joinForm);
		
		return "redirect:/";
	}
	
}
