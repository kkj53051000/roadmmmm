package com.roadmmm.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor
public class StockStudyComment {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="stockstudycomment_id")
	private Long id;
	
	private String content;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "stockstudy_id")
	private StockStudy stockStudy;
	
	public StockStudyComment(String content, User user, StockStudy stockStudy) {
		this.content = content;
		this.user = user;
		this.stockStudy = stockStudy;
	}
}
