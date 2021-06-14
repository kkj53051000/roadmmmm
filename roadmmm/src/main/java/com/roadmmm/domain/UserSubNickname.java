package com.roadmmm.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TableGenerator;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor
@TableGenerator(
		name = "USERSUBNICKNAME_SEQ_GENERATOR",
		table = "ROADMMM_SEQUENCES",
		pkColumnValue = "USERSUBNICKNAME_SEQ", allocationSize = 50)
public class UserSubNickname {
	@Id @GeneratedValue(strategy = GenerationType.AUTO, generator = "USERSUBNICKNAME_SEQ_GENERATOR")
	@Column(name = "usersubnickname_id")
	private long id;
	
	private String subNickname;
	
	public UserSubNickname(String subNickname) {
		this.subNickname = subNickname;
	}
}
