package com.roadmmm.vo;

import java.util.List;

import com.roadmmm.domain.stockstudy.StockStudyTag;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class GuideLineListVo {
	private List<GuideLineListForm> guideLineListForms;
	private PagingForm pagingForm;
	private StockStudyTag tag;
	
	public GuideLineListVo(List<GuideLineListForm> guideLineListForms, PagingForm pagingForm, StockStudyTag tag) {
		this.guideLineListForms = guideLineListForms;
		this.pagingForm = pagingForm;
		this.tag = tag;
	}
}
