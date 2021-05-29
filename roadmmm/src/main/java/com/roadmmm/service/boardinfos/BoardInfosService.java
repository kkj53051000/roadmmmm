package com.roadmmm.service.boardinfos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.roadmmm.domain.boardinfos.BoardInfos;
import com.roadmmm.repository.boardinfos.BoardInfosRepository;
import com.roadmmm.vo.BoardInfosForm;

@Service
@Transactional
public class BoardInfosService {
	@Autowired
	BoardInfosRepository boardInfosRepository;
	
	public int getBoardInfosBestStandard(String board) {
		int bestStandard = boardInfosRepository.selectBoardInfosBestStandard(board);
		
		return bestStandard;
	}
	
	public int getBoardInfosPopularStandard(String board) {
		int popularStandard = boardInfosRepository.selectBoardInfosPopularStandard(board);
		
		return popularStandard;
	}
	
	public void saveBoardInfos(BoardInfosForm boardInfosForm) {
		BoardInfos boardsInfo = new BoardInfos(boardInfosForm.getBestStandard(), boardInfosForm.getPopularStandard(), boardInfosForm.getBoard(), boardInfosForm.getInfo());
		
		boardInfosRepository.insertBoardInfos(boardsInfo);
	}
	
	public List<BoardInfos> getBoardInfos(){
		List<BoardInfos> boardInfos = boardInfosRepository.selectBoardInfos();
		
		return boardInfos;
	}
}
