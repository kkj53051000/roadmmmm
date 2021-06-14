package com.roadmmm.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class GuideLineWriteForm {
	private String title;
	private String content;
	private String sector;
	
	public GuideLineWriteForm(String title, String content, String sector) {
		this.title = title;
		this.content = content;
		this.sector = sector;
	}
}
