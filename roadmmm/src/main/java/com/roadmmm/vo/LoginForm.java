package com.roadmmm.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LoginForm {
	private String userid;
	private String userpw;
	
	public LoginForm(String userid, String userpw) {
		this.userid = userid;
		this.userpw = userpw;
	}
}
