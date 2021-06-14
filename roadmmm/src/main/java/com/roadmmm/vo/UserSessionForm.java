package com.roadmmm.vo;

import java.util.Date;

import com.roadmmm.domain.Role;
import com.roadmmm.domain.UserSubNickname;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class UserSessionForm {
	private long user_id;
	private String userid;
	private String nickname;
	private UserSubNickname subNickname;
	private String email;
	private Date date;
	private Role role;
	
	public UserSessionForm(long user_id, String userid, String nickname, String email) {
		this.user_id = user_id;
		this.userid = userid;
		this.nickname = nickname;
		this.email = email;
	}
	
	public UserSessionForm(long user_id, String userid, String nickname, UserSubNickname subNickname, String email, Date date, Role role) {
		this.user_id = user_id;
		this.userid = userid;
		this.nickname = nickname;
		this.subNickname = subNickname;
		this.email = email;
		this.date = date;
		this.role = role;
	}

}
