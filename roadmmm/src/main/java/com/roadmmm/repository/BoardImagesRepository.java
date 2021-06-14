package com.roadmmm.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.roadmmm.domain.BoardImages;

@Repository
public class BoardImagesRepository {
	@PersistenceContext
	EntityManager em;
	
	public void insertBoardImage(BoardImages boardImages) {
		em.persist(boardImages);
	}
}
