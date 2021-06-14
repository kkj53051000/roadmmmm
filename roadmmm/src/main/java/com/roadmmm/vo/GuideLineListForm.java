package com.roadmmm.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class GuideLineListForm {
	private String titleImg;
	private String title;
	
	public GuideLineListForm(String titleImg, String title) {
		this.titleImg = titleImg;
		this.title = title;
	}
}
