package com.roadmmm.controller;

import java.util.Random;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.roadmmm.domain.User;
import com.roadmmm.service.UserService;
import com.roadmmm.vo.JoinForm;
import com.roadmmm.vo.LoginForm;
import com.roadmmm.vo.UserSessionForm;

@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	private JavaMailSender mailSender;
	
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
		
		
			
			try {
				Random random = new Random();
				int auth = random.nextInt();
				
				MimeMessage message = mailSender.createMimeMessage();
				MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");

				messageHelper.setFrom("roadtomillio"); // 보내는사람 생략하면 정상작동을 안함
				messageHelper.setTo(joinForm.getEmail()); // 받는사람 이메일
				messageHelper.setSubject(joinForm.getNickname() + "님 로드밀 인증 메일입니다."); // 메일제목은 생략이 가능하다
				messageHelper.setText("인증번호 : " + auth); // 메일 내용

				mailSender.send(message);
			} catch (Exception e) {
				System.out.println(e);
			}

        
		
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
