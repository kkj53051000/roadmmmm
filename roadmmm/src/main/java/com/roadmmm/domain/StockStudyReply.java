package com.roadmmm.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
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
public class StockStudyReply {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="stockstudyreply_id")
	private long id;
	
	private String content;
	
	@ManyToOne
	@JoinColumn(name = "stockstudycomment_id")
	private StockStudyComment stockStudyComment;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	public StockStudyReply(String content, StockStudyComment stockStudyComment, User user) {
		this.content = content;
		this.stockStudyComment = stockStudyComment;
		this.user = user;
	}
}
