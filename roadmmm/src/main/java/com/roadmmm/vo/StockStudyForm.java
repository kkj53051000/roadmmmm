package com.roadmmm.vo;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class StockStudyForm {
	private String title;
	private String content;
	private String tag;
	
	public StockStudyForm(String title, String content, String tag) {
		this.title = title;
		this.content = content;
		this.tag = tag;
	}
}
