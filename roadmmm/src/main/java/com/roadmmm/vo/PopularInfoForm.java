package com.roadmmm.vo;

import java.util.Date;

import com.roadmmm.domain.User;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class PopularInfoForm {
	private long boardId;
	private String boardName;
	private String title;
	private Date date;
	private String nickname;
	
	public PopularInfoForm(long boardId, String boardName, String title, Date date, String nickname) {
		this.boardId = boardId;
		this.boardName = boardName;
		this.title = title;
		this.date = date;
		this.nickname = nickname;
	}
}
