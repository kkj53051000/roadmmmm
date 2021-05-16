package com.roadmmm.vo;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.roadmmm.domain.User;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class StockStudyCommentVo {
	private long id;
	private String content;
	private User user;
	@Enumerated(EnumType.STRING)
	private CommentEnum commentEnum;
	
	public StockStudyCommentVo(long id, String content, User user, CommentEnum commentEnum) {
		this.id = id;
		this.content = content;
		this.user = user;
		this.commentEnum = commentEnum;
	}
}
