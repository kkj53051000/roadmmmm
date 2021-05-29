package com.roadmmm.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class BoardInfosForm {
	private int bestStandard;
	private int popularStandard;
	private String board;
	private String info;
	
	public BoardInfosForm(int bestStandard, int popularStandard, String board, String info) {
		this.bestStandard = bestStandard;
		this.popularStandard = popularStandard;
		this.board = board;
		this.info = info;
	}
}
