package com.roadmmm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.roadmmm.domain.UserSubNickname;
import com.roadmmm.repository.UserSubNicknameRepository;

@Service
@Transactional
public class UserSubNicknameService {
	@Autowired
	UserSubNicknameRepository userSubNicknameRepository;
	
	public void setUserSubNickname(String subNickname) {
		UserSubNickname userSubNickname = new UserSubNickname(subNickname);
		
		userSubNicknameRepository.insertUserSubNickname(userSubNickname);
	}
	
	public List<UserSubNickname> getUserSubNickname(){
		List<UserSubNickname> userSubNicknames = userSubNicknameRepository.selectUserSubNicknames();
		
		return userSubNicknames;
	}
}
