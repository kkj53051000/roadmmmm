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
import javax.persistence.TableGenerator;

import com.roadmmm.domain.stockstudy.StockStudyTag;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor
@TableGenerator(
		name = "GUIDELINE_SEQ_GENERATOR",
		table = "ROADMMM_SEQUENCES",
		pkColumnValue = "GUIDELINE_SEQ", allocationSize = 50)
public class GuideLine {
	@Id @GeneratedValue(strategy = GenerationType.AUTO, generator = "GUIDELINE_SEQ_GENERATOR")
	@Column(name = "guideline_id")
	private long id;
	
	private String title;
	private String titleImg;
	private String content;
	private Date date;
	@Enumerated(EnumType.STRING)
	private StockStudyTag tag;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;
	
	public GuideLine(String title, String titleImg, String content, Date date, StockStudyTag tag, User user) {
		this.title = title;
		this.titleImg = titleImg;
		this.content = content;
		this.date = date;
		this.tag = tag;
		this.user = user;
	}
}
