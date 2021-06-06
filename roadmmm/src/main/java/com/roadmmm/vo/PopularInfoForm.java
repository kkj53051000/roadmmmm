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
	//private String nickname;
	private User user;
	
	public PopularInfoForm(long boardId, String boardName, String title, Date date, User user) {
		this.boardId = boardId;
		this.boardName = boardName;
		this.title = title;
		this.date = date;
		this.user = user;
	}
}
