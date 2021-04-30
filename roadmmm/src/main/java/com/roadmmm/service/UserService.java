package com.roadmmm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.roadmmm.domain.User;
import com.roadmmm.repository.UserRepository;
import com.roadmmm.vo.JoinForm;

@Service
@Transactional
public class UserService {
	@Autowired
	UserRepository userRepository;
	
	public void saveUser(JoinForm joinForm) {
		
		User user = new User(joinForm.getUserid(), joinForm.getUserpw(), joinForm.getNickname(), joinForm.getEmail());
		
		userRepository.insertUser(user);
	}
}
