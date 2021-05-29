package com.roadmmm.domain.stockstudy;

import javax.persistence.Column;
import javax.persistence.Entity;
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
		name = "STOCKSTUDYREPLY_SEQ_GENERATOR",
		table = "ROADMMM_SEQUENCES",
		pkColumnValue = "STOCKSTUDYREPLY_SEQ_G", allocationSize = 50)
public class StockStudyReply {
	@Id @GeneratedValue(strategy = GenerationType.AUTO, generator = "STOCKSTUDYREPLY_SEQ_GENERATOR")
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
