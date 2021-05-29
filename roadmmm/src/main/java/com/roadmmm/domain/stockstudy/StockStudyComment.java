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
		name = "STOCKSTUDYCOMMENT_SEQ_GENERATOR",
		table = "ROADMMM_SEQUENCES",
		pkColumnValue = "STOCKSTUDYCOMMENT_SEQ", allocationSize = 50)
public class StockStudyComment {
	@Id @GeneratedValue(strategy = GenerationType.AUTO, generator = "STOCKSTUDYCOMMENT_SEQ_GENERATOR")
	@Column(name="stockstudycomment_id")
	private Long id;
	
	private String content;
	
	@ManyToOne
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
