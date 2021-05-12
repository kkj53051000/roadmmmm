package com.roadmmm.vo;

import java.util.List;

import com.roadmmm.domain.StockStudy;
import com.roadmmm.domain.StockStudyTag;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class StockStudyListVo {
	private List<StockStudy> stockStudys;
	private List<Integer> pageList;
	private boolean beforePage;
	private boolean afterPage;
	private int beforePageNum;
	private int afterPageNum;
	private StockStudyTag tag;
	
	public StockStudyListVo(List<StockStudy> stockStudys, List<Integer> pageList, boolean beforePage, boolean afterPage, int beforePageNum, int afterPageNum, StockStudyTag tag) {
		this.stockStudys = stockStudys;
		this.pageList = pageList;
		this.beforePage = beforePage;
		this.afterPage = afterPage;
		this.beforePageNum = beforePageNum;
		this.afterPageNum = afterPageNum;
		this.tag = tag;
	}
	
}
