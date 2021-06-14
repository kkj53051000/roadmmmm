package com.roadmmm.vo;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class PagingForm {
	private List<Integer> pageList;
	private boolean beforePage;
	private boolean afterPage;
	private int beforePageNum;
	private int afterPageNum;
	private int startPage;
	
	public PagingForm(List<Integer> pageList, boolean beforePage, boolean afterPage, int beforePageNum, int afterPageNum, int startPage) {
		this.pageList = pageList;
		this.beforePage = beforePage;
		this.afterPage = afterPage;
		this.beforePageNum = beforePageNum;
		this.afterPageNum = afterPageNum;
		this.startPage = startPage;
	}
}
