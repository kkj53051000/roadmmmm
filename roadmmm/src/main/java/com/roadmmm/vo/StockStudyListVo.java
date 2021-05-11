package com.roadmmm.vo;

import java.util.List;

import com.roadmmm.domain.StockStudy;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class StockStudyListVo {
	private List<StockStudy> stockStudys;
	private List<Integer> pageList;
	
	public StockStudyListVo(List<StockStudy> stockStudys, List<Integer> pageList) {
		this.stockStudys = stockStudys;
		this.pageList = pageList;
	}
	
}
