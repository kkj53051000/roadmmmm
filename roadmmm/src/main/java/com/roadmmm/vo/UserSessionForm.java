package com.roadmmm.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class UserSessionForm {
	private long user_id;
	private String userid;
	private String nickname;
	private String email;
	
	public UserSessionForm(long user_id, String userid, String nickname, String email) {
		this.user_id = user_id;
		this.userid = userid;
		this.nickname = nickname;
		this.email = email;
	}

}
