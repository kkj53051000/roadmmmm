package com.roadmmm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.roadmmm.domain.User;
import com.roadmmm.repository.UserRepository;
import com.roadmmm.vo.JoinForm;
import com.roadmmm.vo.LoginForm;

@Service
@Transactional
public class UserService {
	@Autowired
	UserRepository userRepository;
	
	public void saveUser(JoinForm joinForm) {
		
		User user = new User(joinForm.getUserid(), joinForm.getUserpw(), joinForm.getNickname(), joinForm.getEmail());
		
		userRepository.insertUser(user);
	}
	
	public User getUser(long user_id) {
		User user = userRepository.selectUser_id(user_id);
		
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
}
