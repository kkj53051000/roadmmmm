package com.roadmmm.vo;

import java.util.List;

import com.roadmmm.domain.stockstudy.StockStudy;
import com.roadmmm.domain.stockstudy.StockStudyComment;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class StockStudyContentVo {
	private StockStudy stockStudy;
	private List<StockStudyComment> stockStudyComment;
	private int upCount;
	private int downCount;
	
	public StockStudyContentVo(StockStudy stockStudy, List<StockStudyComment> stockStudyComment, int upCount, int downCount) {
		this.stockStudy = stockStudy;
		this.stockStudyComment = stockStudyComment;
		this.upCount = upCount;
		this.downCount = downCount;
	}
}
