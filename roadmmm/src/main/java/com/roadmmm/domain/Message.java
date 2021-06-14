package com.roadmmm.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.TableGenerator;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor
@TableGenerator(
		name = "MESSAGE_SEQ_GENERATOR",
		table = "ROADMMM_SEQUENCES",
		pkColumnValue = "MESSAGE_SEQ", allocationSize = 50)
public class Message {
	@Id @GeneratedValue(strategy = GenerationType.AUTO, generator = "MESSAGE_SEQ_GENERATOR")
	@Column(name = "message_id")
	private long id;
	
	private String title;
	private String content;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "receiveuser_id")
	private User receiveUser;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "senduser_id")
	private User sendUser;
	
	public Message(String title, String content, User receiveUser, User sendUser) {
		this.title = title;
		this.content = content;
		this.receiveUser = receiveUser;
		this.sendUser = sendUser;
	}
}
