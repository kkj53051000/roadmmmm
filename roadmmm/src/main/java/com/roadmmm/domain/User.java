package com.roadmmm.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.TableGenerator;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor
@TableGenerator(
		name = "USER_SEQ_GENERATOR",
		table = "ROADMMM_SEQUENCES",
		pkColumnValue = "USER_SEQ", allocationSize = 50)
public class User {
	@Id @GeneratedValue(strategy = GenerationType.AUTO, generator = "USER_SEQ_GENERATOR")
	@Column(name = "user_id")
	private long id;
	
	private String userid;
	private String userpw;
	private String nickname;
	private String email;
	private Date date;
	
	@OneToOne
	@JoinColumn(name = "usersubnickname_id")
	private UserSubNickname subNickname;
	
	private Role role;
	
	
	public User(String userid, String userpw, String nickname, String email, Date date, Role role) {
		this.userid = userid;
		this.userpw = userpw;
		this.nickname = nickname;
		this.email = email;
		this.date = date;
		this.role = role;
	}
	
	public User(String userid, String userpw, String nickname, String email, Date date, UserSubNickname subNickname, Role role) {
		this.userid = userid;
		this.userpw = userpw;
		this.nickname = nickname;
		this.email = email;
		this.date = date;
		this.subNickname = subNickname;
		this.role = role;
	}
}
