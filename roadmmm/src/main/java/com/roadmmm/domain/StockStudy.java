package com.roadmmm.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.sun.istack.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor
public class StockStudy {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="stockstudy_id")
	private long id;
	
	@NotNull
	private String title;
	@NotNull
	private String content;
	@NotNull
	private Date date;
	@NotNull
	@Enumerated(EnumType.STRING)
	private StockStudyTag tag;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;
	
	public StockStudy(String title, String content, Date date, StockStudyTag tag, User user) {
		this.title = title;
		this.content = content;
		this.date = date;
		this.tag = tag;
		this.user = user;
	}
}
