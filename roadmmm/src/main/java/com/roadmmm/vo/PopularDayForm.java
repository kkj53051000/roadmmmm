package com.roadmmm.vo;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class PopularDayForm {
	private List<PopularInfoForm> popularDays;
	private PopularListForm popularListForm;
	private int thisYear;
	private int thisMonth;
	private int thisDay;
	
	public PopularDayForm(PopularListForm popularListForm, int thisYear, int thisMonth, int thisDay) {
		this.popularListForm = popularListForm;
		this.thisYear = thisYear;
		this.thisMonth = thisMonth;
		this.thisDay = thisDay;
	}
	
	public PopularDayForm(List<PopularInfoForm> popularDays, int thisYear, int thisMonth) {
		this.popularDays = popularDays;
		this.thisYear = thisYear;
		this.thisMonth = thisMonth;
	}
}