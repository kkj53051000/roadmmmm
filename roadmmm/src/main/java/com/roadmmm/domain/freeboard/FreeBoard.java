package com.roadmmm.domain.freeboard;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.TableGenerator;

import com.roadmmm.domain.User;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor
@TableGenerator(
		name = "FREEBOARD_SEQ_GENERATOR",
		table = "ROADMMM_SEQUENCES",
		pkColumnValue = "FREEBOARD_SEQ", allocationSize = 50)
public class FreeBoard {
	@Id @GeneratedValue(strategy = GenerationType.AUTO, generator = "FREEBOARD_SEQ_GENERATOR")
	@Column(name="freeboard_id")
	private long id;
	
	private String title;
	private String content;
	private Date date;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;
	
	public FreeBoard(String title, String content, Date date, User user) {
		this.title = title;
		this.content = content;
		this.date = date;
		this.user = user;
	}
}
