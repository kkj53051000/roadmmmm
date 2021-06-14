package com.roadmmm.vo;

import java.util.List;

import com.roadmmm.domain.PopularLive;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class PopularListForm {
	private List<PopularInfoForm> popularInfoForms;
	private List<Integer> pageList;
	private boolean beforePage;
	private boolean afterPage;
	private int beforePageNum;
	private int afterPageNum;
	
	public PopularListForm(List<PopularInfoForm> popularInfoForms, List<Integer> pageList, boolean beforePage, boolean afterPage, int beforePageNum, int afterPageNum) {
		this.popularInfoForms = popularInfoForms;
		this.pageList = pageList;
		this.beforePage = beforePage;
		this.afterPage = afterPage;
		this.beforePageNum = beforePageNum;
		this.afterPageNum = afterPageNum;
	}
}
