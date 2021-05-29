package com.roadmmm.domain.stockstudy;

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

import com.roadmmm.domain.User;
import com.sun.istack.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor
@TableGenerator(
		name = "STOCKSTUDY_SEQ_GENERATOR",
		table = "ROADMMM_SEQUENCES",
		pkColumnValue = "STOCKSTUDY_SEQ", allocationSize = 50)
public class StockStudy {
	@Id @GeneratedValue(strategy = GenerationType.AUTO, generator = "STOCKSTUDY_SEQ_GENERATOR")
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
	
	private int upCount;
	private int downCount;
	
	private boolean bestCheck;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;
	
	public StockStudy(String title, String content, Date date, StockStudyTag tag, int upCount, int downCount, boolean bestCheck, User user) {
		this.title = title;
		this.content = content;
		this.date = date;
		this.tag = tag;
		this.upCount = upCount;
		this.downCount = downCount;
		this.bestCheck = bestCheck;
		this.user = user;
	}
}
