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
		name = "STOCKSTUDYRECOMMEND_SEQ_GENERATOR",
		table = "ROADMMM_SEQUENCES",
		pkColumnValue = "STOCKSTUDYRECOMMEND_SEQ", allocationSize = 50)
public class StockStudyRecommend {
	@Id @GeneratedValue(strategy = GenerationType.AUTO, generator = "STOCKSTUDYRECOMMEND_SEQ_GENERATOR")
	@Column(name="stockstudyrecommend_id")
	private long id;
	
	private boolean updown;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "stockstudy_id")
	private StockStudy stockStudy;
	
	public StockStudyRecommend(boolean updown, User user, StockStudy  stockStudy) {
		this.updown = updown;
		this.user = user;
		this.stockStudy = stockStudy;
	}
}
