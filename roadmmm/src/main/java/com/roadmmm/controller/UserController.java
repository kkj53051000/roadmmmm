package com.roadmmm.controller;

import java.util.Random;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.roadmmm.domain.User;
import com.roadmmm.email.EmailUtil;
import com.roadmmm.service.UserService;
import com.roadmmm.vo.JoinForm;
import com.roadmmm.vo.LoginForm;
import com.roadmmm.vo.UserSessionForm;

@Controller
public class UserController extends JavaMailSenderImpl {
	
	@Autowired
	UserService userService;
	
	@Autowired
	private EmailUtil emailUtil;
	
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
	
	private JavaMailSender javaMailSender;
	
	@PostMapping("/joinprocess")
	public String join(JoinForm joinForm) {
		
		
		
		userService.saveUser(joinForm);
		
		
			Random random = new Random();
			int auth = random.nextInt();
			
			emailUtil.sendEmail("tkarnrwl7418@naver.com", "스프링을 이용한 메일 전송", "되는지 테스트 하는 거예요");
        
        
		
		return "redirect:/";
	} 
	
	
	@PostMapping("/loginprocess")
	public String login(LoginForm loginForm, HttpServletRequest request) {
		
		User user = userService.loginUser(loginForm);
		
		if(user == null) {
			return "redirect:/";
		}
		
		HttpSession session = request.getSession();
		
		UserSessionForm userSession = new UserSessionForm(user.getId(), user.getUserid(), user.getNickname(), user.getEmail());
		
		session.setAttribute("user", userSession);
		
		return "redirect:/";
		
	}
	
}
