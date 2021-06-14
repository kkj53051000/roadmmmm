package com.roadmmm.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TableGenerator;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor
@TableGenerator(
		name = "BOARDIMAGES_SEQ_GENERATOR",
		table = "ROADMMM_SEQUENCES",
		pkColumnValue = "BOARDIMAGES_SEQ", allocationSize = 50)
public class BoardImages {
	@Id @GeneratedValue(strategy = GenerationType.AUTO, generator = "BOARDIMAGES_SEQ_GENERATOR")
	@Column(name = "boardimages_id")
	private long id;
	
	String path;
	
	public BoardImages(String path) {
		this.path = path;
	}
}
