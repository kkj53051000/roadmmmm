package com.roadmmm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.roadmmm.domain.BoardImages;
import com.roadmmm.repository.BoardImagesRepository;

@Service
@Transactional
public class BoardImagesService {
	@Autowired
	BoardImagesRepository boardImagesRepository;
	
	public void saveBoardImage(BoardImages boardImages) {
		boardImagesRepository.insertBoardImage(boardImages);
	}
}
