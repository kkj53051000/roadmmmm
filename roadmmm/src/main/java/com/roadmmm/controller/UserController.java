package com.roadmmm.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.roadmmm.domain.User;
import com.roadmmm.service.UserService;
import com.roadmmm.vo.JoinForm;
import com.roadmmm.vo.LoginForm;

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
	
	@GetMapping("/login")
	public String loginPage() {
		return "login";
	}
	
	@GetMapping("/logout")
	public String logoutPage() {
		return "logout";
	}
	
	@PostMapping("/joinprocess")
	public String join(JoinForm joinForm) {
		
		userService.saveUser(joinForm);
		
		return "redirect:/";
	} 
	
	
	@PostMapping("/loginprocess")
	public String login(LoginForm loginForm, HttpServletRequest request) {
		
		User user = userService.loginUser(loginForm);
		
		if(user == null) {
			return "redirect:/";
		}
		
		HttpSession session = request.getSession();
		session.setAttribute("user", user);
		
		
		return "redirect:/";
		
	}
	
}
