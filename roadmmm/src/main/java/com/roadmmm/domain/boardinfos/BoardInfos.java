package com.roadmmm.domain.boardinfos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TableGenerator;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor
@TableGenerator(
		name = "BOARDINFOS_SEQ_GENERATOR",
		table = "ROADMMM_SEQUENCES",
		pkColumnValue = "BOARDINFOS_SEQ", allocationSize = 50)
public class BoardInfos {
	@Id @GeneratedValue(strategy = GenerationType.AUTO, generator = "BOARDINFOS_SEQ_GENERATOR")
	@Column(name="boardinfos_id")
	private long id;
	
	private int bestStandard;
	private int popularStandard;
	private String board;
	private String info;
	
	public BoardInfos(int bestStandard, int popularStandard, String board, String info) {
		this.bestStandard = bestStandard;
		this.popularStandard = popularStandard;
		this.board = board;
		this.info = info;
	}
}
