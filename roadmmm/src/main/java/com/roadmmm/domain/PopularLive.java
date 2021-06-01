package com.roadmmm.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.TableGenerator;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor
@TableGenerator(
		name = "POPULARLIVE_SEQ_GENERATOR",
		table = "ROADMMM_SEQUENCES",
		pkColumnValue = "POPULARLIVE_SEQ", allocationSize = 50)
public class PopularLive {
	@Id @GeneratedValue(strategy = GenerationType.AUTO, generator = "POPULARLIVE_SEQ_GENERATOR")
	@Column(name = "popularlive_id")
	private long id;
	
	/*
	@ManyToOne
	@JoinColumn(name = "boardinfos_id")
	BoardInfos boardInfos;
	*/
	
	private String boardName;
	
	private long boardId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;
	
	public PopularLive(String boardName, long boardId,  User user) {
		this.boardName = boardName;
		this.boardId = boardId;
		this.user = user;
	}
}
