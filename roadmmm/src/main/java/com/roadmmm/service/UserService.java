package com.roadmmm.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.roadmmm.domain.Role;
import com.roadmmm.domain.User;
import com.roadmmm.domain.UserSubNickname;
import com.roadmmm.repository.UserRepository;
import com.roadmmm.repository.UserSubNicknameRepository;
import com.roadmmm.vo.JoinForm;
import com.roadmmm.vo.LoginForm;

@Service
@Transactional
public class UserService {
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserSubNicknameRepository userSubNicknameRepository;
	
	public void saveUser(JoinForm joinForm) {
		
		Date now = new Date();
		
		User user = new User(joinForm.getUserid(), joinForm.getUserpw(), joinForm.getNickname(), joinForm.getEmail(), now, null, Role.USER);
		
		userRepository.insertUser(user);
	}
	
	public User getUser(long userId) {
		User user = userRepository.selectUser_id(userId);
		
		return user;
	}
	
	public User loginUser(LoginForm loginForm) {
		
		User user = userRepository.selectUserid(loginForm.getUserid());
		
		if(user == null) {
			return null;
		}
		
		if(user.getUserpw().equals(loginForm.getUserpw())) {
			return user;
		}else {
			return null;
		}
		
	}
	
	public void setUserSubNickname(long userId, UserSubNickname subNickname) {
		userRepository.insertUserSubNickname(userId, subNickname);
	}
	
	public UserSubNickname getUserSubNickname(String subNickname) {
		UserSubNickname userSubNickname = userSubNicknameRepository.selectUserSubNickname(subNickname);
		
		return userSubNickname;
	}
}
