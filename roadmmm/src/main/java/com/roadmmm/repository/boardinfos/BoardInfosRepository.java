package com.roadmmm.repository.boardinfos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.roadmmm.domain.boardinfos.BoardInfos;

@Repository
public class BoardInfosRepository {
	@PersistenceContext
	EntityManager em;
	
	public int selectBoardInfosBestStandard(String board) {
		List<BoardInfos> boardsInfos = em.createQuery("select b FROM BoardInfos b where b.board = :board", BoardInfos.class)
				.setParameter("board", board)
				.getResultList();
		
		int bestStandard = boardsInfos.get(0).getBestStandard();
		
		return bestStandard;
	}
	
	public int selectBoardInfosPopularStandard(String board) {
		List<BoardInfos> boardsInfos = em.createQuery("select b FROM BoardInfos b where b.board = :board", BoardInfos.class)
				.setParameter("board", board)
				.getResultList();
		
		int popularStandard = boardsInfos.get(0).getPopularStandard();
		
		return popularStandard;
	}
	
	public void insertBoardInfos(BoardInfos boardsInfo) {
		em.persist(boardsInfo);
	}
	
	public List<BoardInfos> selectBoardInfos(){
		List<BoardInfos> boardInfos = em.createQuery("select b FROM BoardInfos b", BoardInfos.class)
				.getResultList();
		
		return boardInfos;
	}
}
