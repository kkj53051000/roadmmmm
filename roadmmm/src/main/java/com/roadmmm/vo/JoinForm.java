package com.roadmmm.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class JoinForm {
	private String userid;
	private String userpw;
	private String nickname;
	private String email;
	
	public JoinForm(String userid, String userpw, String nickname, String email) {
		this.userid = userid;
		this.userpw = userpw;
		this.nickname = nickname;
		this.email = email;
	}
}
